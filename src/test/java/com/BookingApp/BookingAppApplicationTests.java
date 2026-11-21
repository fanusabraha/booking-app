package com.BookingApp;

import com.BookingApp.repository.LocationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class BookingAppApplicationTests {
    @Autowired MockMvc mvc;
    @Autowired LocationRepository locations;

    @Test
    @org.springframework.transaction.annotation.Transactional
    void sampleVenueCanBeViewed() throws Exception {
        org.junit.jupiter.api.Assertions.assertEquals(50, locations.count());
        var venue = locations.findAll().stream().filter(v -> v.getName().contains("Miami Beach Celebration")).findFirst().orElseThrow();
        org.junit.jupiter.api.Assertions.assertEquals(6, venue.getPictures().size());
        mvc.perform(get("/event/" + venue.getId()))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Next photo")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Miami Beach Celebration")));
        mvc.perform(get("/event/999999")).andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Location not found")));
    }
}




