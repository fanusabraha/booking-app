package com.BookingApp;

import com.BookingApp.domain.EventLocation;
import com.BookingApp.repository.LocationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.util.List;

/** Example data is limited to a fresh, local in-memory database. */
@Component
public class SampleVenues implements CommandLineRunner {
    private final LocationRepository locations;
    private final String databaseUrl;
    public SampleVenues(LocationRepository locations, @Value("${spring.datasource.url}") String databaseUrl) {
        this.locations = locations;
        this.databaseUrl = databaseUrl;
    }
    @Override
    public void run(String... args) throws Exception {
        if (!databaseUrl.startsWith("jdbc:h2:mem:") || locations.count() != 0) return;
        locations.save(sample("Miami Beach Celebration (Example)", "Miami, Florida", 120, 3500,
                "A fictional beach-inspired venue for exploring the app. Details and price are examples.", 0));
        locations.save(sample("New York City Gathering (Example)", "New York, New York", 180, 5000,
                "A fictional city-inspired venue for exploring the app. Details and price are examples.", 2));
    }
    private EventLocation sample(String name, String city, int capacity, int price, String description, int image) throws Exception {
        EventLocation venue = new EventLocation();
        venue.setName(name); venue.setCountry("USA"); venue.setCity(city);
        venue.setStreet("Example address"); venue.setCapacity(capacity); venue.setPrice(price);
        venue.setComment(description);
        venue.setPictures(List.of(new ClassPathResource("sample-venues/sample-" + image + ".jpg").getContentAsByteArray(),
                new ClassPathResource("sample-venues/sample-" + (image + 1) + ".jpg").getContentAsByteArray()));
        return venue;
    }
}
