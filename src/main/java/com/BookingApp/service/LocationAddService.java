package com.BookingApp.service;


import com.BookingApp.domain.EventLocation;
import com.BookingApp.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class LocationAddService {
    @Autowired
    LocationRepository locationRepository;

    public void saveLocation (EventLocation eventLocation, MultipartFile file){
        try {
            // Convert MultipartFile to byte[] and set it in the entity
            if (file != null && !file.isEmpty()) {
                eventLocation.setPictures(file.getBytes());
            }
            locationRepository.save(eventLocation);
        } catch (IOException e) {
            throw new RuntimeException("Error saving file: " + e.getMessage());
        }

    }


}
