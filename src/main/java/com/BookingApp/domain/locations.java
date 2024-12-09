package com.BookingApp.domain;

public class locations {
    private Long id;
    private String location;
    private String country;
    private String city;
    private Integer capacity;
    private Integer price;
    public enum inclusions {
        MusicBand,
        Catering,
        Decorations,
        SelfPreparing;
    }
    public enum features {
        Beach,
        RoofTop,
        SwimmingPool,
        DJ,
        SelfPreparing;

    }

}
