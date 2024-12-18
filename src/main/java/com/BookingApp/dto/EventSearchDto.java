package com.BookingApp.dto;

import java.time.LocalDate;

public class EventSearchDto {
    private Long id;
    private String location;
    private String country;
    private String city;
    private Integer numberOfVisitors;
    private LocalDate date;
    private Integer budget;

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

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "EventDto{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", numberOfVisitors=" + numberOfVisitors +
                ", date=" + date +
                '}';
    }
}
