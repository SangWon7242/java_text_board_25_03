package com.sbs.java.text_board.container;

import com.sbs.java.text_board.article.controller.ArticleController;

import java.util.Scanner;

public class Container {
  public static Scanner scanner;
  public static ArticleController articleController;
  
  static { // 프로그램 실행시 딱 한번 실행
    scanner = new Scanner(System.in);

    articleController = new ArticleController();
  }
}
