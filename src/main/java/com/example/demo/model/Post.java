package com.example.demo.model;
import com.example.demo.model.User;
import com.example.demo.model.Comment;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;

@Entity
@Table(name = "Posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postID;

    public void setPostID(Long postID) {
        this.postID = postID;
    }

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private User user;

    @Lob
    private String content;

    private String image;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}