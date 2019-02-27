package com.example.opentravel.model;


import org.hibernate.annotations.NaturalId;
import javax.persistence.*;

@Entity
@Table(name = "tourists")
public class Tourist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private String name;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private String sname;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private String email;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private String address;

    public Tourist() {

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

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}