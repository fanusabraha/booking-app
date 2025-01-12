package com.BookingApp.web;
import com.BookingApp.domain.ContactRequest;
import com.BookingApp.service.ContactRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/contact")
public class ContactRequestController {

    @Autowired
    private ContactRequestService contactRequestService;

    @PostMapping("/{eventId}")
    public String handleContactRequest(
            @PathVariable("eventId") Long eventId,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String availability,
            @RequestParam String additionalInfo,
            ModelMap model) {

        ContactRequest request = new ContactRequest();
        request.setName(name);
        request.setEmail(email);
        request.setPhone(phone);
        request.setAvailability(availability);
        request.setAdditionalInfo(additionalInfo);
        request.setRequestDate(LocalDateTime.now());
        // Add logic to fetch and associate the event location by eventId

        contactRequestService.saveRequest(request);

        model.addAttribute("successMessage", "Your request has been submitted successfully.");
        return "redirect:/event/search/results";
    }
}
