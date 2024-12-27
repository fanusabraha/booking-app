package com.BookingApp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public class EventSearch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String city;
    private Integer numberOfVisitors;
    private LocalDate date;
    private Integer serviceHours;
    private Integer budget;
    public enum occasion {
        WEDDING, BAPTISM, GRADUATION, ENGAGEMENT, BRIDAL_SHOWER, HOLIDAYS, ANNIVERSARIES, CONCERT, PARTY, SPECIAL_VENUE
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getBudget() {return budget;}

    public void setBudget(Integer budget) {this.budget = budget;}
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
