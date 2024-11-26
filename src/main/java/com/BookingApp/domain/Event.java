package com.BookingApp.domain;

import java.time.LocalDate;

public class Event {
    private Long id;
    private String location;
    private String country;
    private String city;
    private Integer numberOfVisitors;
    private LocalDate date;

    public enum occasion {
        WEDDING, BAPTISM, GRADUATION, ENGAGEMENT, BRIDAL_SHOWER, HOLIDAYS, ANNIVERSARIES, CONCERT, PARTY
    };
    // additional attributes for more filtered options
    /*
    * private Integer durationInHours (after it is being shown available on the date)
    *private Boolean isPrivate;
    *private Double averageRating;
    * private List<Review> reviews;
    * private Double budget;
    *
    * */

    // additional attributes for contacting the user
    /*
    *private String contactEmail;
    * private String contactPhone;
    * private String description;
    *
    * */
}
