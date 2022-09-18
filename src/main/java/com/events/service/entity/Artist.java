package com.events.service.entity;

import org.hibernate.annotations.SQLDelete;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@SQLDelete(sql = "UPDATE artist SET deleted = true WHERE id=?")
public class Artist extends DataEntity {

    private String name;

    public Artist() {
    }

    public Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
