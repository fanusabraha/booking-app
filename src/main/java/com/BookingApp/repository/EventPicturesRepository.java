package com.BookingApp.repository;

import com.BookingApp.domain.EventPictures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventPicturesRepository extends JpaRepository<EventPictures, Long> {
}
