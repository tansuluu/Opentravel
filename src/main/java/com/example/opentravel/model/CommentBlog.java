package com.example.opentravel.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "commentBlog")
public class CommentBlog {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "text")
    private String comentText;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateCom", nullable = false)
    private Date dateCom;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Blog blog;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public CommentBlog(String comentText, Date dateCom, Blog blog, User user) {
        this.comentText = comentText;
        this.dateCom = dateCom;
        this.blog = blog;
        this.user = user;
    }

    public CommentBlog() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
