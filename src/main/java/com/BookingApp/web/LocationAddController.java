package com.BookingApp.web;

import com.BookingApp.domain.EventLocation;
import com.BookingApp.service.LocationAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/addlocation")
public class LocationAddController {
    @Autowired
    private LocationAddService locationAddService;

    @GetMapping("")
    public String addLocation(Model model) {
        model.addAttribute("eventLocation", new EventLocation());
        return "addlocation";
    }

    @PostMapping("")
    public String addLocation(@ModelAttribute EventLocation eventLocation,
            @RequestParam("pictureFile") MultipartFile[] files) {
        return "dashboard";
    }
}