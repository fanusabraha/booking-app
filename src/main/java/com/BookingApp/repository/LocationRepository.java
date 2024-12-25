package com.BookingApp.repository;

import com.BookingApp.domain.EventLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<EventLocation, Long> {
    @Query("SELECT el FROM EventLocations el WHERE " +
            "(:country IS NULL OR LOWER(el.country) = LOWER(:country)) AND " +
            "(:city IS NULL OR LOWER(el.city) = LOWER(:city)) AND " +
            "(:capacity IS NULL OR el.capacity >= :capacity) AND " +
            "(:budget IS NULL OR el.price <= :budget)")
    List<EventLocation> searchLocations(@Param("country") String country,
                                        @Param("city") String city,
                                        @Param("capacity") Integer capacity,
                                        @Param("budget") Integer budget);

}
