package com.sbs.java.text_board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    List<Article> articles = new ArrayList<>();

    int lastArticleId = 0;
    Article lastArticle = null;

    System.out.println("== JAVA 텍스트 게시판 구현 ==");

    while (true) {
      System.out.print("명령어) ");
      String cmd = sc.nextLine();

      if(cmd.equals("/usr/article/write")) {
        System.out.println("== 게시물 작성 ==");
        System.out.print("제목 : ");
        String subject = sc.nextLine();

        System.out.print("내용 : ");
        String content = sc.nextLine();

        int id = ++lastArticleId;

        Article article = new Article(id, subject, content);
        lastArticle = article;

        articles.add(article);
        System.out.printf("%d번 게시물이 등록되었습니다.\n", article.id);
      }
      else if(cmd.equals("/usr/article/detail")) {
        Article article = lastArticle;

        if(article == null) {
          System.out.println("게시물이 존재하지 않습니다.");
          continue;
        }

        System.out.println("== 게시물 상세보기 ==");
        System.out.printf("번호 : %d\n", article.id);
        System.out.printf("제목 : %s\n", article.subject);
        System.out.printf("내용 : %s\n", article.content);

      }
      else if(cmd.equals("/usr/article/list")) {
        if(articles.isEmpty()) {
          System.out.println("게시물이 존재하지 않습니다.");
          continue;
        }

        System.out.println("== 게시물 리스트 ==");

        System.out.println("번호 | 제목");

        // v1
        /*
        for(int i = 0; i < articles.size(); i++) {
          Article article = articles.get(i);
          System.out.printf("%d | %s\n", article.id, article.subject);
        }
        */

        // v2
        /*
        for(Article article : articles) {
          System.out.printf("%d | %s\n", article.id, article.subject);
        }
        */

        // v3
        articles.forEach(
            article -> System.out.printf("%d | %s\n", article.id, article.subject)
        );
      }
      else if(cmd.equals("exit")) {
        System.out.println("게시판 프로그램을 종료합니다.");
        break;
      }
      else {
        System.out.println("명령어를 잘 못 입력하였습니다.");
      }
    }

    System.out.println("== JAVA 텍스트 게시판 종료 ==");
    sc.close();
  }
}
