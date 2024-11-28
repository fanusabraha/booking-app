package com.BookingApp.web;

import com.BookingApp.dto.EventDto;
import com.BookingApp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {
    @Autowired
    EventService eventService;
    @GetMapping("/")
    public String homePage(ModelMap model ){
        EventDto eventDto= new EventDto();
        model.addAttribute("event",eventDto);
        return "homepage";
    }
    @PostMapping("/")
    public String homePage (ModelMap model, EventDto eventDto){
        List<EventDto> events = new ArrayList<>();
        events.add(eventDto);
        EventDto newevnt = (EventDto) model.get("event");

        System.out.println(newevnt.getCity());
        return "homepage";
    }

}
