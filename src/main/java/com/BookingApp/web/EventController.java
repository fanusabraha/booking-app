package com.BookingApp.web;

import com.BookingApp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/event")
public class EventController {
    @Autowired
    EventService eventService;
    @GetMapping("")
    public String homePage(ModelMap model ){
        
        return "homepage";
    }

}
