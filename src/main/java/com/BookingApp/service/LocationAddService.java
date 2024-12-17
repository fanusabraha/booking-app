package com.BookingApp.service;


import com.BookingApp.domain.EventLocation;
import com.BookingApp.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class LocationAddService {
    @Autowired
    LocationRepository locationRepository;

    public void saveLocation (@ModelAttribute EventLocation eventLocation,
                              @RequestParam("pictureFile")MultipartFile[] files){
        try {
            // Process uploaded files
            if (files != null && files.length > 0) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                for (MultipartFile file : files) {
                    if (!file.isEmpty()) {
                        outputStream.write(file.getBytes());
                    }
                }
                // Save file data into the `pictures` field
                //eventLocation.setPictures(outputStream.toByteArray());
                byte[] combinedBytes = outputStream.toByteArray();
                eventLocation.setPictures(combinedBytes);
            }

            // Save the entity
            locationRepository.save(eventLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<EventLocation> findAllLocations() {
        List<EventLocation> allLocations = locationRepository.findAll();
        for (EventLocation available: allLocations){
            if (available.getPictures()!=null){
                String base64Image = Base64.getEncoder().encodeToString(available.getPictures());
                available.setBase64Image(base64Image);
            }
        }
       return allLocations;
    }
}
