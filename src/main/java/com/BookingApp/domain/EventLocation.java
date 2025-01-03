package com.BookingApp.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "EventLocations")
public class EventLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String city;
    private Integer capacity;
    private Integer price;
    private String comment;
    private String street;
    @ElementCollection
    @Lob
    private List<byte[]> pictures;
    @Transient
    private List<String> base64Images;
    @ElementCollection
    @CollectionTable(name = "event_bookings", joinColumns = @JoinColumn(name = "location_id"))
    @Column(name = "booked_date")
    private List<LocalDate> bookedDates = new ArrayList<>();
    // i will check this transient later
//    @Transient
//    private MultipartFile [] pictureFile;
    // check the orphan removal
    //@OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List <EventPictures> eventPictures = new ArrayList<>();

    // including the enums enumtypes to ensure in the html
    @Enumerated(EnumType.STRING)
    private inclusions inclusion;

    @Enumerated(EnumType.STRING)
    private features feature;

    // thses enums needs adjustments because one location can be used for many purposes not only one
    public enum inclusions {
        MusicBand,
        Catering,
        Decorations,
        MusicBand_Catering_and_Decoration,
        MusicBand_and_Catering,
        Catering_and_Decoration,
        No_MusicBand_Catering_and_Decoration_included,
        SelfPreparing;
    }

    public enum features {
        Beach,
        RoofTop,
        SwimmingPool,
        DJ,
        SelfPreparing,
        Beach_RoofTop_and_SwimmingPool,
        RoofTop_and_SwimmingPool,
        SwimmingPool_and_Beach;

    }

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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public List<byte[]> getPictures() {
        return pictures;
    }

    public void setPictures(List<byte[]> pictures) {
        this.pictures = pictures;
    }

    //public List<EventPictures> getEventPictures() {return eventPictures;}

    //public void setEventPictures(List<EventPictures> eventPictures) {this.eventPictures = eventPictures;}

    public inclusions getInclusion() {
        return inclusion;
    }

    public void setInclusion(inclusions inclusion) {
        this.inclusion = inclusion;
    }

    public features getFeature() {
        return feature;
    }

    public void setFeature(features feature) {
        this.feature = feature;
    }

    //public MultipartFile[] getPictureFile() {return pictureFile;}

    //public void setPictureFile(MultipartFile [] pictureFile) {this.pictureFile = pictureFile;}
    // this is being used for viewing the pictures in the front web, need to be checked for other option or necessity
    public List<String> getBase64Images() {
        return base64Images;
    }

    public void setBase64Images(List<String> base64Images) {
        this.base64Images = base64Images;
    }

    public List<LocalDate> getBookedDates() {
        return bookedDates;
    }

    public void setBookedDates(List<LocalDate> bookedDates) {
        this.bookedDates = bookedDates;
    }

    @Override
    public String toString() {
        return "EventLocation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                ", comment='" + comment + '\'' +
                ", address='" + street + '\'' +
                ", pictures=" + pictures +
                ", base64Images=" + base64Images +
                ", bookedDates=" + bookedDates +
                ", inclusion=" + inclusion +
                ", feature=" + feature +
                '}';
    }
}

