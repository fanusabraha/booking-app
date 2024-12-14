package com.BookingApp.web;

import com.BookingApp.domain.EventLocation;
import com.BookingApp.domain.EventPictures;
import com.BookingApp.dto.EventSearchDto;
import com.BookingApp.repository.LocationRepository;
import com.BookingApp.service.LocationAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

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
    public String addLocation(@ModelAttribute EventLocation eventLocation) {
        try {
            // Process uploaded files
            MultipartFile[] files = eventLocation.getPictureFile();
            if (files != null) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                for (MultipartFile file : files) {
                    if (!file.isEmpty()) {
                        outputStream.write(file.getBytes());
                    }
                }
                eventLocation.setPictures(outputStream.toByteArray()); // Save combined pictures as byte[]
            }

            // Save the entity
            locationAddService.saveLocation(eventLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/addlocation";
    }
}
