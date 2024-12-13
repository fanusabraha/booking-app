package com.BookingApp.web;

import com.BookingApp.dto.EventSearchDto;
import com.BookingApp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {
    @Autowired
    EventService eventService;
    List<EventSearchDto> events = new ArrayList<>();
    @GetMapping("/")
    public String homePageGet(ModelMap model ){
        EventSearchDto eventDto= new EventSearchDto();
        model.addAttribute("event",eventDto);
        model.addAttribute("searchedEvents", events);
        return "eventsearch";
    }
    @PostMapping("/")
    public String homePagePost (@ModelAttribute("event") EventSearchDto eventDto, ModelMap model){
        events.add(eventDto);
        // illustration only to be deleted
       for (EventSearchDto eachEvent: events){
           System.out.println(eachEvent);
       }
        return "redirect:/event/";
    }

}
