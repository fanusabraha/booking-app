package com.BookingApp.web;

import com.BookingApp.domain.EventLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addLocation")
public class LocationAddController {
    @Autowired
    EventLocation eventLocation;
    @GetMapping("/new")
    public String AddLocation (Model model){
    return
    }
}
