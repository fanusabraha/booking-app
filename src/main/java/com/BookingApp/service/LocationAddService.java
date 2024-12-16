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
                eventLocation.setPictures(outputStream.toByteArray());
            }

            // Save the entity
            locationRepository.save(eventLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
