package com.BookingApp.domain;

import jakarta.persistence.*;

@Entity
public class EventPictures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private byte [] imageData;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Location location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte [] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public Location getEventLocation() {
        return location;
    }

    public void setEventLocation(Location location) {
        this.location = location;
    }

}
