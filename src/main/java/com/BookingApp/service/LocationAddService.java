package com.BookingApp.service;


import com.BookingApp.domain.EventLocation;
import com.BookingApp.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class LocationAddService {
    @Autowired
    LocationRepository locationRepository;

    public void saveLocation (@ModelAttribute EventLocation eventLocation,
                              @RequestParam("pictureFile")MultipartFile[] files){
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
        for (EventLocation available: allLocations){
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
    public List<EventLocation> searchLocations(String country, String name, String city, Integer numberOfVisitors, Integer budget) {
        List<EventLocation> allLocations = findAllLocations(); // Reuse the method to fetch all locations
        return allLocations.stream()
                .filter(eventLocation -> (country == null || eventLocation.getCountry().equalsIgnoreCase(country)) &&
                        (name == null || eventLocation.getName().equalsIgnoreCase(name)) ||
                        (city == null || eventLocation.getCity().equalsIgnoreCase(city)) ||
                        (numberOfVisitors == null || eventLocation.getCapacity() >= numberOfVisitors) ||
                        (budget == null || eventLocation.getPrice() >= budget))
                .toList();
    }
    public EventLocation findById(Long id){
        EventLocation location = locationRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Eventlocation with this Id not found"));
        // for rendering the images to webpage
        if (location.getPictures() != null) {
            List<String> base64Images = location.getPictures().stream()
                    .map(picture -> Base64.getEncoder().encodeToString(picture))
                    .toList();
            location.setBase64Images(base64Images);
        }
        return location;
    }
    public void saveById (Long id, EventLocation eventLocation,List<Integer> removePicturesIndices, MultipartFile[] newPictures){
        EventLocation location = locationRepository.findById(id).
                orElseThrow(()-> new IllegalArgumentException("Eventlocation with this Id not found"));
        if (eventLocation.getName()!=null && !eventLocation.getName().isEmpty() ){
            location.setName(eventLocation.getName());
        }
        if (eventLocation.getCountry()!=null && !eventLocation.getCountry().isEmpty() ){
            location.setCountry(eventLocation.getCountry());
        }
        if (eventLocation.getCity()!=null && !eventLocation.getCity().isEmpty() ){
            location.setCity(eventLocation.getCity());
        }
        if (eventLocation.getCapacity()!=null){
            location.setCapacity(eventLocation.getCapacity());
        }
        if (eventLocation.getPrice()!=null){
            location.setPrice(eventLocation.getPrice());
        }
        if (eventLocation.getComment()!=null && !eventLocation.getComment().isEmpty() ){
            location.setComment(eventLocation.getComment());
        }
        if (removePicturesIndices != null && !removePicturesIndices.isEmpty()) {
            List<byte[]> updatedPictures = new ArrayList<>(location.getPictures());
            for (int index : removePicturesIndices) {
                updatedPictures.remove(index);
            }
            location.setPictures(updatedPictures);
        }

        // Handle new picture uploads
        if (newPictures != null && newPictures.length > 0) {
            for (MultipartFile file : newPictures) {
                try {
                    location.getPictures().add(file.getBytes());
                } catch (IOException e) {
                    throw new RuntimeException("Error while uploading new pictures", e);
                }
            }
        }

        // Save updated location
        locationRepository.save(location);
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
    public void deleteLocationById(Long id){
        locationRepository.deleteById(id);
    }
}
