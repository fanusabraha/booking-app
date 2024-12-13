package com.BookingApp.service;


import com.BookingApp.domain.EventLocation;
import com.BookingApp.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class LocationAddService {
    @Autowired
    LocationRepository locationRepository;

    public void saveLocation (EventLocation eventLocation, MultipartFile file){
        {
            // Convert MultipartFile to byte[] and set it in the entity
            if (file != null && !file.isEmpty()) {
                eventLocation.setPictures(file.getBytes());
            }
            locationRepository.save(eventLocation);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception (log it or rethrow it as a custom exception)
        }

    }


}
