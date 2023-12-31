package com.example.demo.service;
import com.example.demo.model.Article;
import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {
    private final CommentRepository commentRepository;
    public List<Comment> listComments(Article article) {
        if (article != null) return commentRepository.findByArticle(article);
        return null;
    }
    public void saveComment(Comment comment) {
        log.info("Saving new {}", comment);
        commentRepository.save(comment);
    }
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
    public Comment getCommentById(long id) {
        return commentRepository.findById(id).orElse(null);
    }

}