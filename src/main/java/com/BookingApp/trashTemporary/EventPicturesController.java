package com.BookingApp.trashTemporary;

//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//// illustration purposes because image should be added alongside the location
//@Controller
//@RequestMapping("")
//public class EventPicturesController {
//    @Autowired
//    EventPicturesService eventPicturesService;
//
//    @GetMapping("/image")
//    public String saveImage (){
//        eventPicturesService.savePicturesLocallyToDatabase();
//        return"redirect:";
//    }
//    @GetMapping("/allImages")
//    public String getAllImages (Model model){
//         List<String> images= eventPicturesService.findAllImages();
//         model.addAttribute("images",images);
//        return "allImages";
//    }
//
//}
