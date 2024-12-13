package com.BookingApp.web;

import com.BookingApp.domain.EventLocation;
import com.BookingApp.dto.EventSearchDto;
import com.BookingApp.repository.LocationRepository;
import com.BookingApp.service.LocationAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addlocation")
public class LocationAddController {
    @Autowired
    LocationAddService locationAddService;
    @GetMapping("")
    public String addLocation (Model model){
       EventLocation eventLocation = new EventLocation();
       model.addAttribute(eventLocation);
    return"addlocation";
    }
    @PostMapping("/new")
    public String addLocation (@ModelAttribute("eventLocation") EventLocation eventLocation){

        locationAddService.saveLocation(eventLocation);
        return"redirect:";
    }
}
