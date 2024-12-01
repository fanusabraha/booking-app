package com.BookingApp.web;

import com.BookingApp.domain.User;
import com.BookingApp.dto.UserDto;
import com.BookingApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
@RestController("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String logIn(ModelMap map){
        UserDto userDto = new UserDto();
        map.addAttribute("user",userDto);
        return"login";
    }
}
