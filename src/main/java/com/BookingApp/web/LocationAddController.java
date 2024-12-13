package com.BookingApp.web;

import com.BookingApp.domain.EventLocation;
import com.BookingApp.dto.EventSearchDto;
import com.BookingApp.repository.LocationRepository;
import com.BookingApp.service.LocationAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/addlocation")
public class LocationAddController {
    @Autowired
    LocationAddService locationAddService;
    @GetMapping("")
    public String addLocation (Model model){
       EventLocation eventLocation = new EventLocation();
       // replace this later less redundant
       model.addAttribute("eventLocation", eventLocation);
    return"addlocation";
    }
    @PostMapping("")
    public String addLocation (@ModelAttribute EventLocation eventLocation,
                               @RequestParam("pictures") MultipartFile file){

        try {
            // Convert MultipartFile to byte[] and set it in the entity
            if (file != null && !file.isEmpty()) {
                eventLocation.setPictures(file.getBytes());
            }
            locationAddService.saveLocation(eventLocation);
        } catch (IOException e) {
            e.printStackTrace();  // You can also log this exception
        }
        return "redirect:/addlocation";
    }
}
