package com.BookingApp.web;

import com.BookingApp.domain.User;
import com.BookingApp.dto.UserDto;
import com.BookingApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String logIn(ModelMap map){
        map.addAttribute("user",new UserDto());
        return"signUp";
    }
    @PostMapping("/register")
    public String logIn (@ModelAttribute("user") User user){
    userService.save(user);
    return"redirect:/event/";
    }
}
