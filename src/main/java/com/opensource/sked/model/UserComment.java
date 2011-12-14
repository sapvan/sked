package com.opensource.sked.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserComment {
    @Id
    @GeneratedValue
    private Long userCommentId;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    public UserComment() {
    }
    
    public UserComment(String comment) {
        super();
        this.comment = comment;
    }

    public Long getUserCommentId() {
        return userCommentId;
    }

    public void setUserCommentId(Long userCommentId) {
        this.userCommentId = userCommentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

}
