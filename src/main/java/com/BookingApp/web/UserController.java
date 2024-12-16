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
    ArrayList<UserDto> users= new ArrayList<>();

    @GetMapping("/register")
    public String logIn(ModelMap map){
        map.addAttribute("user",new UserDto());
        return"register";
    }
    @PostMapping("/register")
    public String logIn (@ModelAttribute("user") UserDto userDto){
        users.add(userDto);
        return"redirect:/event/";
    }
}
