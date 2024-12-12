package com.BookingApp.service;

import com.BookingApp.domain.EventPictures;
import com.BookingApp.repository.EventPicturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.logging.log4j.util.Cast.cast;

@Service
@RestController
@RequestMapping("/")
public class EventPicturesService {
    @Autowired
    EventPicturesRepository eventPicturesRepository;
     public void SaveImagesToRepository (){
         EventPictures eventPictures = new EventPictures();
         eventPictures.setImageData();
         eventPictures.setId(1L);
         eventPicturesRepository.save()
     }
}
