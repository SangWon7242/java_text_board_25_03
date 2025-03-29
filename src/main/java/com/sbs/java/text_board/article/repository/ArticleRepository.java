package com.sbs.java.text_board.article.repository;

import com.sbs.java.text_board.article.dto.Article;
import com.sbs.java.text_board.util.Util;

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
        .forEach(i -> save("제목" + i, "내용" + i, 1, "user1"));
  }

  public int save(String subject, String content, int memberId, String writerName) {
    int id = ++lastId;

    Article article = new Article(id, subject, content, memberId, writerName);

    articles.add(article);

    return article.getId();
  }


  private List<Article> findAllOrderById(String orderBy) {
    List<Article> sortedArticles = articles;

    if(orderBy.equals("idAsc")) {
      return articles;
    }

    if(orderBy.equals("idDesc")) {
      sortedArticles = Util.reverseList(articles);
    }

    return sortedArticles;
  }

  public List<Article> findAll(String searchKeyword, String orderBy) {
    List<Article> filteredArticles = findAllOrderById(orderBy);

    if (!searchKeyword.isEmpty()) {
      List<Article> sortedArticles = findAllOrderById(orderBy);

      filteredArticles = new ArrayList<>();

      for (Article article : sortedArticles) {
        boolean matched = article.getSubject().contains(searchKeyword) || article.getContent().contains(searchKeyword);

        if (matched) filteredArticles.add(article);
      }
    }

    return filteredArticles;
  }

  public Article findById(int id) {
    return articles.stream()
        .filter(article -> article.getId() == id)
        .findFirst()
        .orElse(null);
  }

  public void modify(int id, String subject, String content) {
    Article article = findById(id);

    article.setSubject(subject);
    article.setContent(content);
  }

  public void remove(int id) {
    Article article = findById(id);

    articles.remove(article);
  }
}
