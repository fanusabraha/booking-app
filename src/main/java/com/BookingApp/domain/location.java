package com.BookingApp.domain;

import jakarta.persistence.*;

@Entity(name = "EventLocations")
public class location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private String country;
    private String city;
    private Integer capacity;
    private Integer price;
    private String comment;
    @Lob
    private byte [] pictures;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public byte[] getPictures() {
        return pictures;
    }

    public void setPictures(byte[] pictures) {
        this.pictures = pictures;
    }
}

