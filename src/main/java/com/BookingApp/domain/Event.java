package com.BookingApp.domain;

public class Event {
    private String location;
    private String continent;
    private String country;
    private Integer size;
    public enum occasion {
        WEDDING, BAPTISM, GRADUATION, ENGAGEMENT, BRIDAL_SHOWER, HOLIDAYS, ANNIVERSARIES, CONCERT, PARTY
    };

}
