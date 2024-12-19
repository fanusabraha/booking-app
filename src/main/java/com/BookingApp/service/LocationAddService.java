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
import java.util.Optional;

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
    public List<EventLocation> searchLocations(String country, String location, String city, Integer numberOfVisitors, Integer budget) {
        List<EventLocation> allLocations = findAllLocations(); // Reuse the method to fetch all locations
        return allLocations.stream()
                .filter(eventLocation -> (country == null || eventLocation.getCountry().equalsIgnoreCase(country)) &&
                        (location == null || eventLocation.getLocation().equalsIgnoreCase(location)) ||
                        (city == null || eventLocation.getCity().equalsIgnoreCase(city)) ||
                        (numberOfVisitors == null || eventLocation.getCapacity() >= numberOfVisitors) ||
                        (budget == null || eventLocation.getPrice() >= budget))
                .toList();
    }
    public EventLocation findById(Long id){
        return locationRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Eventlocation with this Id not found"));
    }
}
