package com.BookingApp.service;


import com.BookingApp.domain.EventLocation;
import com.BookingApp.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Service
public class LocationAddService {
    @Autowired
    LocationRepository locationRepository;

    public void saveLocation(@ModelAttribute EventLocation eventLocation,
                             @RequestParam("pictureFile") MultipartFile[] files) {
        try {
            if (files != null && files.length > 0) {
                List<byte[]> pictureList = new ArrayList<>();
                for (MultipartFile file : files) {
                    if (!file.isEmpty()) {
                        System.out.println("Processing file: " + file.getOriginalFilename() + ", size: " + file.getSize() + " bytes");
                        pictureList.add(file.getBytes());
                    }
                }
                eventLocation.setPictures(pictureList);
            }

            locationRepository.save(eventLocation);
            System.out.println("Location saved successfully with multiple pictures!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<EventLocation> findAllLocations() {
        List<EventLocation> allLocations = locationRepository.findAll();
        for (EventLocation available : allLocations) {
            if (available.getPictures() != null && !available.getPictures().isEmpty()) {
                List<String> base64Images = new ArrayList<>();
                for (byte[] picture : available.getPictures()) {
                    base64Images.add(Base64.getEncoder().encodeToString(picture));
                }
                available.setBase64Images(base64Images);
            }
        }
        return allLocations;
    }

    public EventLocation findById(Long id) {
        EventLocation location = locationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Eventlocation with this Id not found"));
        // for rendering the images to webpage
        if (location.getPictures() != null) {
            List<String> base64Images = location.getPictures().stream()
                    .map(picture -> Base64.getEncoder().encodeToString(picture))
                    .toList();
            location.setBase64Images(base64Images);
        }
        return location;
    }

    public void saveById(Long id, EventLocation updatedLocation, List<Integer> removePicturesIndices, MultipartFile[] newPictures, LocalDate newBookingDate, Map<String, String> updatedDates, List<Integer> removeBookedDates) {
        EventLocation existingLocation = locationRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("EventLocation with this Id not found"));
        if (updatedLocation.getName() != null && !updatedLocation.getName().isEmpty()) {
            existingLocation.setName(updatedLocation.getName());
        }
        if (updatedLocation.getStreet() != null && !updatedLocation.getStreet().isEmpty()) {
            existingLocation.setStreet(updatedLocation.getStreet());
        }
        if (updatedLocation.getCountry() != null && !updatedLocation.getCountry().isEmpty()) {
            existingLocation.setCountry(updatedLocation.getCountry());
        }
        if (updatedLocation.getCity() != null && !updatedLocation.getCity().isEmpty()) {
            existingLocation.setCity(updatedLocation.getCity());
        }
        if (updatedLocation.getCapacity() != null) {
            existingLocation.setCapacity(updatedLocation.getCapacity());
        }
        if (updatedLocation.getPrice() != null) {
            existingLocation.setPrice(updatedLocation.getPrice());
        }
        if (updatedLocation.getInclusion() != null) {
            existingLocation.setInclusion(updatedLocation.getInclusion());
        }
        if (updatedLocation.getFeature() != null) {
            existingLocation.setFeature(updatedLocation.getFeature());
        }
        if (updatedLocation.getComment() != null && !updatedLocation.getComment().isEmpty()) {
            existingLocation.setComment(updatedLocation.getComment());
        }
        if (newBookingDate != null && !existingLocation.getBookedDates().contains(newBookingDate)) {
            existingLocation.getBookedDates().add(newBookingDate);
        }
        if (removePicturesIndices != null && !removePicturesIndices.isEmpty()) {
            List<byte[]> updatedPictures = new ArrayList<>(existingLocation.getPictures());
            for (int index : removePicturesIndices) {
                updatedPictures.remove(index);
            }
            existingLocation.setPictures(updatedPictures);
        }

        // Handle new picture uploads
        if (newPictures != null && newPictures.length > 0) {
            for (MultipartFile file : newPictures) {
                try {
                    existingLocation.getPictures().add(file.getBytes());
                } catch (IOException e) {
                    throw new RuntimeException("Error while uploading new pictures", e);
                }
            }
        }
        if (updatedDates != null && !updatedDates.isEmpty()) {
            List<LocalDate> currentDates = existingLocation.getBookedDates();
            for (Map.Entry<String, String> entry : updatedDates.entrySet()) {
                int index = Integer.parseInt(entry.getKey().replace("updatedDates[", "").replace("]", ""));
                LocalDate newDate = LocalDate.parse(entry.getValue());
                currentDates.set(index, newDate);
            }
        }

        // Remove selected booked dates
        if (removeBookedDates != null && !removeBookedDates.isEmpty()) {
            List<LocalDate> currentDates = existingLocation.getBookedDates();
            removeBookedDates.sort(Collections.reverseOrder()); // Remove from the highest index to avoid shifting issues
            for (int index : removeBookedDates) {
                currentDates.remove(index);
            }
        }
        // Save updated location
        locationRepository.save(existingLocation);
    }

    // other alternatives for less redundancy
//    private void updateIfPresent(String newValue, Consumer<String> updater) {
//        if (newValue != null && !newValue.isEmpty()) {
//            updater.accept(newValue);
//        }
//    }
//    public void saveById(Long id, EventLocation eventLocation) {
//        EventLocation location = locationRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Event location with this ID not found"));
//
//        updateIfPresent(eventLocation.getLocation(), location::setLocation);
//        updateIfPresent(eventLocation.getCountry(), location::setCountry);
//        updateIfPresent(eventLocation.getCity(), location::setCity);
//
//        if (eventLocation.getCapacity() != null) {
//            location.setCapacity(eventLocation.getCapacity());
//        }
//        if (eventLocation.getPrice() != null) {
//            location.setPrice(eventLocation.getPrice());
//        }
//        updateIfPresent(eventLocation.getComment(), location::setComment);
//
//        locationRepository.save(location);
//    }
    public void deleteLocationById(Long id) {
        locationRepository.deleteById(id);
    }
}
