package com.example.opentravel.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "text")
    private String postText;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datePost", nullable = false)
    private Date dateCom;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User writer;

    public Post(String postText, Date dateCom, User user, User writer) {
        this.postText = postText;
        this.dateCom = dateCom;
        this.user = user;
        this.writer = writer;
    }

    public Post() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public Date getDateCom() {
        return dateCom;
    }

    public void setDateCom(Date dateCom) {
        this.dateCom = dateCom;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getWriter() {
        return writer;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }
}
