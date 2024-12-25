package com.BookingApp.service;

import com.BookingApp.domain.EventLocation;
import com.BookingApp.domain.EventSearch;
import com.BookingApp.dto.EventSearchDto;
import com.BookingApp.repository.EventRepository;
import com.BookingApp.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventSearchService {
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    private EventRepository eventRepository;
    public List<EventLocation> searchLocations(String country, String name, String city, Integer numberOfVisitors, Integer budget) {
        List<EventLocation> allLocations = locationRepository.findAll(); // Reuse the method to fetch all locations
        return locationRepository.searchLocations(country, name, city, budget, budget);
    }
//        return allLocations.stream()
//                .filter(eventLocation -> (country == null || eventLocation.getCountry().equalsIgnoreCase(country)) &&
//                        (name == null || eventLocation.getName().equalsIgnoreCase(name)) &&
//                        (city == null || eventLocation.getCity().equalsIgnoreCase(city)) &&
//                        (numberOfVisitors == null || eventLocation.getCapacity() >= numberOfVisitors) &&
//                        (budget == null || eventLocation.getPrice() >= budget))
//                .toList();


//    public void addSerachedEvent (EventSearchDto eventSearchDto){
//        EventSearch eventSearch = new EventSearch();
//        eventSearch.setBudget(eventSearchDto.getBudget());
//        eventSearch.setCity(eventSearchDto.getCity());
//        eventSearch.setCountry(eventSearchDto.getCountry());
//        eventSearch.setName(eventSearchDto.getName());
//        eventSearch.setNumberOfVisitors(eventSearchDto.getNumberOfVisitors());
//        eventSearch.setId(eventSearchDto.getId());
//        eventSearch.setDate(LocalDate.EPOCH);
//      eventRepository.save(eventSearch);
//    }
}
