package com.BookingApp.repository;

import com.BookingApp.domain.ContactRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRequestRepository extends JpaRepository<ContactRequest, Long> {
}
