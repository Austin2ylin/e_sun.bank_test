package com.example.demo.service;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.util.Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        comment.setContent(Util.cleanHtmlContent(comment.getContent()));
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }
    @Transactional
    public void performComplexOperationOnComment(Comment comment) {
        commentRepository.save(comment);
        commentRepository.customProcedureOnComment(comment.getContent());
    }
}