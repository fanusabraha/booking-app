package com.BookingApp.web;

import com.BookingApp.dto.EventDto;
import com.BookingApp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/event")
public class EventController {
    @Autowired
    EventService eventService;
    List<EventDto> events = new ArrayList<>();
    @GetMapping("/")
    public String homePageGet(ModelMap model ){
        EventDto eventDto= new EventDto();
        model.addAttribute("event",eventDto);
        model.addAttribute();
        return "homepage";
    }
    @PostMapping("/")
    public String homePagePost (@ModelAttribute("event") EventDto eventDto, ModelMap model){
        events.add(eventDto);
        
       for (EventDto eachEvent: events){
           System.out.println(eachEvent);
       }
        return "redirect:/event/";
    }

}
