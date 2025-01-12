package com.BookingApp.service;

import com.BookingApp.domain.ContactRequest;
import com.BookingApp.repository.ContactRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactRequestService {

    @Autowired
    private ContactRequestRepository repository;

    public ContactRequest saveRequest(ContactRequest request) {
        return repository.save(request);
    }

    public List<ContactRequest> getAllRequests() {
        return repository.findAll();
    }
}