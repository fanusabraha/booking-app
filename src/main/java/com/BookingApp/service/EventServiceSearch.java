package com.BookingApp.service;

import com.BookingApp.dto.EventSearchDto;
import com.BookingApp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceSearch {
    @Autowired
    private EventRepository eventRepository;
    public void addSerachedEvent (EventSearchDto eventSearchDto){
      eventRepository.save()
    }
}
