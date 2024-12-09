package com.BookingApp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String location;
    private String country;
    private String city;
    private Integer numberOfVisitors;
    private LocalDate date;
    private Integer serviceHours;

    public enum occasion {
        WEDDING, BAPTISM, GRADUATION, ENGAGEMENT, BRIDAL_SHOWER, HOLIDAYS, ANNIVERSARIES, CONCERT, PARTY
    };

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

    public Integer getNumberOfVisitors() {
        return numberOfVisitors;
    }

    public void setNumberOfVisitors(Integer numberOfVisitors) {
        this.numberOfVisitors = numberOfVisitors;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getServiceHours() {return serviceHours;}

    public void setServiceHours(Integer serviceHours) {this.serviceHours = serviceHours;}
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
