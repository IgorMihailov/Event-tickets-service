package com.events.service.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@SQLDelete(sql = "UPDATE event SET deleted = true WHERE id=?")
public class Event extends DataEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    @JsonBackReference(value = "types-categories")
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    private String name;

    private BigDecimal price;

    private String address;

    private String description;

    public Event() {
    }

    public Event(City city, Artist artist, String name, BigDecimal price, String address, String description) {
        this.city = city;
        this.artist = artist;
        this.name = name;
        this.price = price;
        this.address = address;
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
