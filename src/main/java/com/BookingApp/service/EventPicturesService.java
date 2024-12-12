package com.BookingApp.service;

import com.BookingApp.domain.EventPictures;
import com.BookingApp.repository.EventPicturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class EventPicturesService {
    @Autowired
    EventPicturesRepository eventPicturesRepository;
     public void SaveImagesToRepository () {
         String imagePath = "C:\\Users\\fanus\\OneDrive\\Desktop\\programming folders\\booking-app\\docs\\Hamburg.jpg";

         byte[] imageBytes = null;
         try {
             imageBytes = Files.readAllBytes(new File(imagePath).toPath());

         } catch (IOException e) {
             System.out.println("Error reading image: " + e.getMessage());
         }
         EventPictures eventPictures = new EventPictures();
         eventPictures.setImageData(imageBytes);
         eventPictures.setId(1L);
         eventPicturesRepository.save(eventPictures);
     }
}
