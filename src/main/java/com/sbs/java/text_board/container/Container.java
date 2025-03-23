package com.sbs.java.text_board.container;

import com.sbs.java.text_board.article.controller.ArticleController;
import com.sbs.java.text_board.article.repository.ArticleRepository;
import com.sbs.java.text_board.article.service.ArticleService;

import java.util.Scanner;

public class Container {
  public static Scanner scanner;

  public static ArticleRepository articleRepository;

  public static ArticleService articleService;

  public static ArticleController articleController;
  
  static { // 프로그램 실행시 딱 한번 실행
    scanner = new Scanner(System.in);

    articleRepository = new ArticleRepository();

    articleService = new ArticleService();

    articleController = new ArticleController();
  }
}
