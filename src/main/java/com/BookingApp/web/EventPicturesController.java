package com.BookingApp.web;


import com.BookingApp.service.EventPicturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class EventPicturesController {
    @Autowired
    EventPicturesService eventPicturesService;

    @GetMapping("/image")
    public String saveImage (){
        eventPicturesService.SaveImagesToRepository();
        return"homepage";
    }
}
