package com.BookingApp.service;

import com.BookingApp.domain.EventPictures;
import com.BookingApp.repository.EventPicturesRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventPicturesService {
    @Autowired
    EventPicturesRepository eventPicturesRepository;
     public void savePicturesLocallyToDatabase() {
         String imagePath = "C:\\Users\\fanus\\OneDrive\\Desktop\\programming folders\\booking-app\\docs\\Hamburg.jpg";

         byte[] imageBytes = null;
         try {
             imageBytes = Files.readAllBytes(new File(imagePath).toPath());

         } catch (IOException e) {
             System.out.println("Error reading image: " + e.getMessage());
         }
         EventPictures eventPictures = new EventPictures();
         eventPictures.setImageData(imageBytes);
         eventPicturesRepository.save(eventPictures);
     }
     public List<String > findAllImages(){

         return eventPicturesRepository.findAll().stream()
                 .map(eventPicture -> Base64.encodeBase64String(eventPicture.getImageData()))
                 .collect(Collectors.toList());
     }


}
