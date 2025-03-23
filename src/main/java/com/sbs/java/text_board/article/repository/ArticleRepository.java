package com.sbs.java.text_board.article.repository;

import com.sbs.java.text_board.article.dto.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArticleRepository {
  private List<Article> articles;
  private int lastId;

  public ArticleRepository() {
    articles = new ArrayList<>();
    lastId = 0;

    makeArticleTestData();
  }

  public void makeArticleTestData() {
    IntStream.rangeClosed(1, 100)
        .forEach(i -> save("제목" + i, "내용" + i));
  }

  public int save(String subject, String content) {
    int id = ++lastId;

    Article article = new Article(id, subject, content);

    articles.add(article);

    return article.id;
  }

  public List<Article> findAll() {
    return articles;
  }

  public Article findById(int id) {
    return articles.stream()
        .filter(article -> article.id == id)
        .findFirst()
        .orElse(null);
  }

  public void modify(int id, String subject, String content) {
    Article article = findById(id);

    article.subject = subject;
    article.content = content;
  }

  public void remove(int id) {
    Article article = findById(id);

    articles.remove(article);
  }
}
