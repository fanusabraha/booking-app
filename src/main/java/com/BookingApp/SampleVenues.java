package com.BookingApp;

import com.BookingApp.domain.EventLocation;
import com.BookingApp.repository.LocationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

/** Demonstration data is limited to an empty local in-memory database. */
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
        String[][] cities = {
            {"Miami", "Florida"}, {"New York", "New York"}, {"Birmingham", "Alabama"},
            {"Anchorage", "Alaska"}, {"Phoenix", "Arizona"}, {"Little Rock", "Arkansas"},
            {"Los Angeles", "California"}, {"Denver", "Colorado"}, {"Hartford", "Connecticut"},
            {"Wilmington", "Delaware"}, {"Atlanta", "Georgia"}, {"Honolulu", "Hawaii"},
            {"Boise", "Idaho"}, {"Chicago", "Illinois"}, {"Indianapolis", "Indiana"},
            {"Des Moines", "Iowa"}, {"Wichita", "Kansas"}, {"Louisville", "Kentucky"},
            {"New Orleans", "Louisiana"}, {"Portland", "Maine"}, {"Baltimore", "Maryland"},
            {"Boston", "Massachusetts"}, {"Detroit", "Michigan"}, {"Minneapolis", "Minnesota"},
            {"Jackson", "Mississippi"}, {"Kansas City", "Missouri"}, {"Billings", "Montana"},
            {"Omaha", "Nebraska"}, {"Las Vegas", "Nevada"}, {"Manchester", "New Hampshire"},
            {"Newark", "New Jersey"}, {"Albuquerque", "New Mexico"}, {"Charlotte", "North Carolina"},
            {"Fargo", "North Dakota"}, {"Columbus", "Ohio"}, {"Oklahoma City", "Oklahoma"},
            {"Portland", "Oregon"}, {"Philadelphia", "Pennsylvania"}, {"Providence", "Rhode Island"},
            {"Charleston", "South Carolina"}, {"Sioux Falls", "South Dakota"}, {"Nashville", "Tennessee"},
            {"Austin", "Texas"}, {"Salt Lake City", "Utah"}, {"Burlington", "Vermont"},
            {"Richmond", "Virginia"}, {"Seattle", "Washington"}, {"Charleston", "West Virginia"},
            {"Milwaukee", "Wisconsin"}, {"Cheyenne", "Wyoming"}
        };
        byte[][] photos = new byte[19][];
        for (int i = 0; i < photos.length; i++)
            photos[i] = new ClassPathResource("sample-venues/sample-" + i + ".jpg").getContentAsByteArray();
        List<EventLocation> examples = new ArrayList<>();
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i][0];
            EventLocation venue = new EventLocation();
            String name = i == 0 ? "Miami Beach Celebration" : i == 1 ? "New York City Gathering" : city + " Gathering Space";
            venue.setName(name + " (Example)");
            venue.setCountry("USA");
            venue.setCity(city + ", " + cities[i][1]);
            venue.setStreet("Example address");
            venue.setCapacity(80 + (i % 7) * 25);
            venue.setPrice(2200 + (i % 10) * 450);
            venue.setComment("A fictional event space in " + city + " for exploring the app. Details, pricing, and photos are illustrative and do not represent an actual venue.");
            List<byte[]> gallery = new ArrayList<>();
            for (int j = 0; j < 6; j++) gallery.add(photos[(i * 7 + j * 3) % photos.length]);
            venue.setPictures(gallery);
            examples.add(venue);
        }
        try (var reader = new java.io.BufferedReader(new java.io.InputStreamReader(
                new ClassPathResource("sample-venues/world-cities.txt").getInputStream(), java.nio.charset.StandardCharsets.UTF_8))) {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] parts = line.split("\\|", 2);
                EventLocation venue = new EventLocation();
                venue.setName(parts[0] + " Gathering Space (Example)");
                venue.setCity(parts[0]); venue.setCountry(parts[1]); venue.setStreet("Example address");
                venue.setCapacity(80 + (i % 7) * 25); venue.setPrice(2200 + (i % 10) * 450);
                venue.setComment("A fictional event space for review. Details, prices and photos are illustrative.");
                List<byte[]> gallery = new ArrayList<>();
                for (int j = 0; j < 6; j++) gallery.add(photos[((i + 50) * 7 + j * 3) % photos.length]);
                venue.setPictures(gallery);
                examples.add(venue);
                i++;
            }
        }
        locations.saveAll(examples);
    }
}



