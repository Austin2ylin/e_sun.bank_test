package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.model.Comment;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    
    @Autowired
    private CommentRepository commentRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post editPost(Long id, Post post) {
        post.setPostID(id);
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
    
    @Transactional
    public void updatePostWithComments(Long postId, Post post, List<Comment> comments) {
        editPost(postId, post);
        for (Comment comment : comments) {
            comment.setPost(post);
            commentRepository.save(comment);
        }
    }
}