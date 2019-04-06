package com.example.opentravel.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "favorite")
public class Favorite {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "placeId", length = 128)
    private long placeId;

    public Favorite() {
    }

    public Favorite(long placeId) {
        this.placeId = placeId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(long placeId) {
        this.placeId = placeId;
    }
}
