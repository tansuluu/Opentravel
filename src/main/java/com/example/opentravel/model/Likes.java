package com.example.opentravel.model;
import javax.persistence.*;

@Entity
@Table(name = "likes")
public class Likes {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "username",length = 128)
    private String username;
    @Column(name = "appId")
    private long appId;
    @Column(name = "blogID")
    private long blogID;

    public Likes() {
    }

    public Likes(String username, long app_id) {
        this.username = username;
        this.appId = app_id;
    }

    public Likes(long blogID,String username) {
        this.username = username;
        this.blogID = blogID;
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

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }

    public long getBlogID() {
        return blogID;
    }

    public void setBlogID(long blogID) {
        this.blogID = blogID;
    }
}