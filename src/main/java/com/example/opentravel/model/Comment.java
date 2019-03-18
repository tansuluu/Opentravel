package com.example.opentravel.model;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "username")
    private String username;
    @Column(name = "idPlace")
    private long idPlace;
    @Column(name = "blogID ")
    private long blogID;
    @Column(name = "text")
    private String comentText;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateCom", nullable = false)
    private Date dateCom;
    @Column(name = "image", length = 136)
    private String image;

    public Comment() {
    }

    public Comment(String username, long id_place, String comentText) {
        this.username = username;
        this.idPlace = id_place;
        this.comentText = comentText;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(long idPlace) {
        this.idPlace = idPlace;
    }

    public String getComentText() {
        return comentText;
    }

    public void setComentText(String comentText) {
        this.comentText = comentText;
    }

    public Date getDateCom() {
        return dateCom;
    }

    public void setDateCom(Date dateCom) {
        this.dateCom = dateCom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getBlogID() {
        return blogID;
    }

    public void setBlogID(long blogID) {
        this.blogID = blogID;
    }
}