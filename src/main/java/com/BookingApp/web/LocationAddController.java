package com.BookingApp.web;

import com.BookingApp.domain.EventLocation;
import com.BookingApp.service.LocationAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/locations")
public class LocationAddController {
    @Autowired
    private LocationAddService locationAddService;

    @GetMapping("/add")
    public String addLocation(Model model) {
        model.addAttribute("eventLocation", new EventLocation());
        return "addlocation";
    }

    @PostMapping("/add")
    public String addLocation(@ModelAttribute EventLocation eventLocation,
            @RequestParam("pictureFile") MultipartFile[] files) {
        locationAddService.saveLocation(eventLocation,files);
        return "redirect:/locations/all";
    }
    @GetMapping("/all")
    public String listOfEvents(ModelMap model){
        List<EventLocation> availableLocations = locationAddService.findAllLocations();
        model.addAttribute("events", availableLocations);
        return "listOfLocations";
    }
    @GetMapping("/update/{id}")
    public String editLocation( @PathVariable("id") Long id, Model model){
        EventLocation location = locationAddService.findById(id);
        model.addAttribute("location", location);
        return "editLocation";
    }
    @PostMapping("update/{id}")
    public String editLocation(@PathVariable("id") Long id,
                               @ModelAttribute EventLocation eventLocation,
                               @RequestParam(value = "removePictures", required = false) List<Integer> removePicturesIndices,
                               @RequestParam(value = "newPictures", required = false) MultipartFile[] newPictures){
        locationAddService.saveById(id, eventLocation, removePicturesIndices, newPictures);
        return"redirect:/locations/all";
    }
    @PostMapping("/delete/{id}")
    public String deleteLocation(@PathVariable("id") Long id){
        locationAddService.deleteLocationById(id);
        return"redirect:/locations/all";
    }

}