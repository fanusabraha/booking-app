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
                               @RequestParam("pictures") MultipartFile[] files){

        try {
            // Convert MultipartFile to byte[] and set it in the entity
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    EventPictures eventPicture = new EventPictures();
                    eventPicture.setImageData(file.getBytes());
                    eventPicture.setEventLocation(eventLocation); // Associate with EventLocation
                    eventLocation.getEventPictures().add(eventPicture); // Add to eventPictures list
                }
            }
            locationAddService.saveLocation(eventLocation);  // Save the eventLocation with its pictures
        } catch (IOException e) {
            e.printStackTrace();  // Log the error
        }
        return "redirect:/addlocation";
    }
}
