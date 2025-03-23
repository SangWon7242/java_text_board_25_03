package com.sbs.java.text_board.article.service;

import com.sbs.java.text_board.article.dto.Article;
import com.sbs.java.text_board.article.repository.ArticleRepository;

import java.util.List;

public class ArticleService {
  private ArticleRepository articleRepository;

  public ArticleService() {
    articleRepository = new ArticleRepository();
  }

  public int save(String subject, String content) {
    return articleRepository.save(subject, content);
  }

  public List<Article> findAll() {
    return articleRepository.findAll();
  }

  public Article findById(int id) {
    return articleRepository.findById(id);
  }

  public void modify(int id, String subject, String content) {
    articleRepository.modify(id, subject, content);
  }

  public void remove(int id) {
    articleRepository.remove(id);
  }
}
