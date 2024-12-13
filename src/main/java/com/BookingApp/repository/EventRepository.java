package com.BookingApp.repository;

import com.BookingApp.domain.EventSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventSearch, Long> {

}
