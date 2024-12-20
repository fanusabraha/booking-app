package com.BookingApp.web;

import com.BookingApp.domain.EventLocation;
import com.BookingApp.dto.EventSearchDto;
import com.BookingApp.service.EventSearchService;
import com.BookingApp.service.LocationAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/event")
public class EventSearchController {
    // examine if using the locationAddService is the best solution
    @Autowired
    LocationAddService locationAddService;
    @Autowired
    EventSearchService eventServiceSearch;
    @GetMapping("/")
    public String homePageGet(ModelMap model ){
        model.addAttribute("event",new EventSearchDto());
        //model.addAttribute("searchedEvents", events);
        return "eventsSearch";
    }
    @PostMapping("/")
    public String homePagePost (@ModelAttribute("event") EventSearchDto eventDto, ModelMap model){
        eventServiceSearch.addSerachedEvent(eventDto);
        return "redirect:/event/";
    }
    // this is to see real time search
    @GetMapping("/search")
    @ResponseBody
    public List<EventLocation> searchEvents(
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Integer numberOfVisitors,
            @RequestParam(required = false) Integer budget) {
        return locationAddService.searchLocations(country, name, city, numberOfVisitors, budget);
    }
    // To see all the added elements or locations



}
