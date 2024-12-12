package com.BookingApp.web;


import com.BookingApp.service.EventPicturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class EventPicturesController {
    @Autowired
    EventPicturesService eventPicturesService;

    @GetMapping("/image")
    public String saveImage (){
        eventPicturesService.Save();
        return"homepage";
    }
    @GetMapping("/allImages")
    public String getAllImages (Model model){
         List<Long> images= eventPicturesService.findAllIds();
         model.addAttribute("images",images);
        return "allImages";
    }

}
