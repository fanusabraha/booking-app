package com.BookingApp.service;

import com.BookingApp.repository.EventPicturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventPicturesService {
    @Autowired
    EventPicturesRepository eventPicturesRepository;
     public void SaveImagesToRepository (){
         
         eventPicturesRepository.save()
     }
}
