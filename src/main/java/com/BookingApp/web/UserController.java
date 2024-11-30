package com.BookingApp.web;

import com.BookingApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
@RestController("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String logIn(){
        return"login";
    }
}
