package com.example.demo.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "article", uniqueConstraints = @UniqueConstraint(columnNames={"article_id"}))
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Article {
    @Id
    @SequenceGenerator(name = "article_seq",
            sequenceName = "article_sequence",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_seq") //возможно изза этой строки у нас проблема с айдишниками
    @Column(name = "article_id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "text", columnDefinition = "text")
    private String text;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private ApplicationUser author;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "article", fetch = FetchType.EAGER)
    private List<Comment> comments;
    @Column(name = "previewImageId")
    private Long previewImageId;
    public void addCommentToArticle(Comment comment) {
        comments.add(comment);
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", comments='" + comments + '\'' +
                ", text='" + text + '\'' +

                '}';
    }
}
