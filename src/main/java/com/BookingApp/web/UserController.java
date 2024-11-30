package com.BookingApp.web;

import com.BookingApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
@Controller
@RestController
public class UserController {
    @Autowired
    private UserService userService;
}
