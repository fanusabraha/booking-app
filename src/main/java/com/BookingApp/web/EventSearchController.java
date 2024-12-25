package com.BookingApp.web;

import com.BookingApp.domain.EventLocation;
import com.BookingApp.dto.EventSearchDto;
import com.BookingApp.service.EventSearchService;
import com.BookingApp.service.LocationAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/event")
public class EventSearchController {
    // examine if using the locationAddService is the best solution
    @Autowired
    LocationAddService locationAddService;
    @Autowired
    EventSearchService eventServiceSearch;

    @GetMapping("/search")
    public String homePageGet(ModelMap model ){
        model.addAttribute("event",new EventSearchDto());
        return "eventsSearch";
    }

    @PostMapping("/search")
    public String homePagePost (@ModelAttribute("event") EventSearchDto eventDto,
                                @RequestParam(required = false) String country,
                                @RequestParam(required = false) String city,
                                @RequestParam(required = false) Integer numberOfVisitors,
                                @RequestParam(required = false) Integer budget,
                                RedirectAttributes redirectAttributes){
       List<EventLocation> matchingLocations = eventServiceSearch.searchLocations(country,city, numberOfVisitors, budget);
        redirectAttributes.addFlashAttribute("searchedEvents",matchingLocations);
        redirectAttributes.addFlashAttribute("searchedCriteria", eventDto);
        return "redirect:/event/search/results";
    }

    @GetMapping("/search/results")
    public String searchResults(ModelMap map){
        if (!map.containsAttribute("searchedEvents")) {
            map.addAttribute("message", "No results found. Please try again.");
        } else if (((List<?>) map.get("searchedEvents")).isEmpty()) {
            map.addAttribute("message", "No matching locations found.");
        }
        return"availableLocations";
    }
    // To see all the added elements or locations



}
