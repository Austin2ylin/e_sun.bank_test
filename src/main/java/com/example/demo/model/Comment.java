package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.example.demo.model.User;
import com.example.demo.model.Post;
import com.example.demo.util.Util;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;

@Entity
@Table(name = "Comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentID;

    public void setCommentID(Long commentID) {
        this.commentID = commentID;
    }

    public void setContent(String content) {
        this.content = Util.cleanHtmlContent(content);
    }

    public void setPost(Post post) {
        this.post = post;
    }
    public Long getCommentID() {
        return this.commentID;
    }
    
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public Post getPost() {
        return this.post;
    }
    
    public String getContent() {
        return this.content;
    }
    
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "postID", nullable = false)
    private Post post;

    @Lob
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}