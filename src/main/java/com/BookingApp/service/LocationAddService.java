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
        return locationRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Eventlocation with this Id not found"));
    }
    public void saveById (Long id, EventLocation eventLocation){
        EventLocation location = locationRepository.findById(id).
                orElseThrow(()-> new IllegalArgumentException("Eventlocation with this Id not found"));
        if (eventLocation.getName()!=null && !eventLocation.getName().isEmpty() ){
            eventLocation.setName(eventLocation.getName());
        }
        if (eventLocation.getCountry()!=null && !eventLocation.getCountry().isEmpty() ){
            eventLocation.setCountry(eventLocation.getCountry());
        }
        if (eventLocation.getCity()!=null && !eventLocation.getCity().isEmpty() ){
            eventLocation.setCity(eventLocation.getCity());
        }
        if (eventLocation.getCapacity()!=null){
            eventLocation.setName(eventLocation.getName());
        }
        if (eventLocation.getPrice()!=null){
            eventLocation.setName(eventLocation.getName());
        }
        if (eventLocation.getComment()!=null && !eventLocation.getComment().isEmpty() ){
            eventLocation.setName(eventLocation.getName());
        }
    }
}
