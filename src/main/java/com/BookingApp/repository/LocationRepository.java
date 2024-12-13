package com.BookingApp.repository;

import com.BookingApp.domain.EventLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<EventLocation, Long> {

}
