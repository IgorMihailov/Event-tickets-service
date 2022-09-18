package com.events.service.entity;

import org.hibernate.annotations.SQLDelete;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@SQLDelete(sql = "UPDATE city SET deleted = true WHERE id=?")
public class City extends DataEntity{

    private String name;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
