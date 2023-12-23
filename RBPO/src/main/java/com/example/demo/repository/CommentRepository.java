package com.example.demo.repository;
import com.example.demo.model.ApplicationUser;
import com.example.demo.model.Article;
import com.example.demo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findByAuthor(ApplicationUser author);
    List<Comment> findByArticle(Article article);
}