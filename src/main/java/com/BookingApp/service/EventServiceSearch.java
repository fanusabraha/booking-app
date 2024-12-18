package com.BookingApp.service;

import com.BookingApp.domain.EventSearch;
import com.BookingApp.dto.EventSearchDto;
import com.BookingApp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EventServiceSearch {
    @Autowired
    private EventRepository eventRepository;
    public void addSerachedEvent (EventSearchDto eventSearchDto){
        EventSearch eventSearch = new EventSearch();
        eventSearch.setBudget(eventSearchDto.getBudget());
        eventSearch.setCity(eventSearchDto.getCity());
        eventSearch.setCountry(eventSearchDto.getCountry());
        eventSearch.setLocation(eventSearchDto.getLocation());
        eventSearch.setNumberOfVisitors(eventSearchDto.getNumberOfVisitors());
        eventSearch.setId(eventSearchDto.getId());
        eventSearch.setDate(LocalDate.EPOCH);
      eventRepository.save(eventSearch);
    }
}
