package com.BookingApp.service;

import com.BookingApp.domain.EventLocation;
import com.BookingApp.domain.EventSearch;
import com.BookingApp.dto.EventSearchDto;
import com.BookingApp.repository.EventRepository;
import com.BookingApp.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class EventSearchService {
    @Autowired
    LocationRepository locationRepository;
    public List<EventLocation> searchLocations(String country, String city, Integer numberOfVisitors, Integer budget) {
        List<EventLocation> filteredLocations = locationRepository.searchLocations(country, city, numberOfVisitors, budget);
        for (EventLocation available: filteredLocations){
            if (available.getPictures() != null && !available.getPictures().isEmpty()) {
                List<String> base64Images = new ArrayList<>();
                for (byte[] picture : available.getPictures()) {
                    base64Images.add(Base64.getEncoder().encodeToString(picture));
                }
                available.setBase64Images(base64Images);
            }
        }
        return filteredLocations;
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
