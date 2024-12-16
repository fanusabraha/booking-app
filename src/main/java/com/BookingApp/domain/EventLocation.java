package com.BookingApp.domain;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "EventLocations")
public class EventLocation {
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
    //@Column(columnDefinition = "BLOB")
    private byte [] pictures;
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

    //public List<EventPictures> getEventPictures() {return eventPictures;}

    //public void setEventPictures(List<EventPictures> eventPictures) {this.eventPictures = eventPictures;}

    public inclusions getInclusion() {  return inclusion;}

    public void setInclusion(inclusions inclusion) {  this.inclusion = inclusion;}

    public features getFeature() { return feature;}

    public void setFeature(features feature) {  this.feature = feature;}

    //public MultipartFile[] getPictureFile() {return pictureFile;}

    //public void setPictureFile(MultipartFile [] pictureFile) {this.pictureFile = pictureFile;}
}

