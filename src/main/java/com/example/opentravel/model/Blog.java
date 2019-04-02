package com.example.opentravel.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "title", length = 128)
    @NotEmpty(message = "*Please provide a ")
    private String title;
    @Column(name = "category", length = 128)
    @NotEmpty(message = "*Please choose a ")
    private String category;
    @Column(columnDefinition = "LONGTEXT",name = "text")
    @NotEmpty(message = "*Please write a")
    private String text;
    @Column(name = "smallText", length = 700)
    private String smallText;
    @Column(name = "photo1", length = 200)
    private String photo1;
    @Column(name = "photo2", length = 200)
    private String photo2;
    @Column(name = "photo3", length = 36)
    private String photo3;
    @Column(name = "username", length = 136)
    private String username;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "view",nullable = true)
    private int view;
    @Column(name = "comNumber")
    private int comNumber;
    @Column(name = "likes")
    private int likes;
    @Column(name = "image", length = 136)
    private String image;

    public Blog() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public String getPhoto3() {
        return photo3;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getComNumber() {
        return comNumber;
    }

    public void setComNumber(int comNumber) {
        this.comNumber = comNumber;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSmallText() {
        return smallText;
    }

    public void setSmallText(String smallText) {
        this.smallText = smallText;
    }
}