package com.sbs.java.text_board;

import com.sbs.java.text_board.base.Rq;
import com.sbs.java.text_board.util.Util;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
  private static void makeArticleTestData(List<Article> articles) {
    IntStream.rangeClosed(1, 100)
        .forEach(
            i -> articles.add(new Article(i, "제목" + i, "내용" + i))
        );
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    List<Article> articles = new ArrayList<>();

    makeArticleTestData(articles);

    int lastArticleId = articles.get(articles.size() - 1).id;

    System.out.println("== JAVA 텍스트 게시판 구현 ==");

    while (true) {
      System.out.print("명령어) ");
      String cmd = sc.nextLine();

      Rq rq = new Rq(cmd);

      if (rq.getUrlPath().equals("/usr/article/write")) {
        System.out.println("== 게시물 작성 ==");
        System.out.print("제목 : ");
        String subject = sc.nextLine();

        System.out.print("내용 : ");
        String content = sc.nextLine();

        int id = ++lastArticleId;

        Article article = new Article(id, subject, content);

        articles.add(article);
        System.out.printf("%d번 게시물이 등록되었습니다.\n", article.id);
      } else if (rq.getUrlPath().equals("/usr/article/detail")) {
        actionUsrArticleShowDetail(articles, rq);
      } else if (rq.getUrlPath().equals("/usr/article/list")) {
        actionUsrArticleShowList(articles, rq);
      } else if (rq.getUrlPath().equals("exit")) {
        System.out.println("게시판 프로그램을 종료합니다.");
        break;
      } else {
        System.out.println("명령어를 잘 못 입력하였습니다.");
      }
    }

    System.out.println("== JAVA 텍스트 게시판 종료 ==");
    sc.close();
  }

  private static void actionUsrArticleShowDetail(List<Article> articles, Rq rq) {
    Map<String, String> params = rq.getParams();

    if(!params.containsKey("id")) {
      System.out.println("id값을 입력해주세요.");
      return;
    }

    int id = 0;

    try {
      id = Integer.parseInt(params.get("id"));
    } catch (NumberFormatException e) {
      System.out.println("id를 정수형태로 입력해주세요.");
      return;
    }

    // 리스트에 게시물이 비어 있는 경우
    if (articles.isEmpty()) {
      System.out.println("게시물이 존재하지 않습니다.");
      return;
    }

    if(id > articles.size()) {
      System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
      return;
    }

    Article article = articles.get(id - 1);

    System.out.println("== 게시물 상세보기 ==");
    System.out.printf("번호 : %d\n", article.id);
    System.out.printf("제목 : %s\n", article.subject);
    System.out.printf("내용 : %s\n", article.content);
  }

  private static void actionUsrArticleShowList(List<Article> articles, Rq rq) {
    if (articles.isEmpty()) {
      System.out.println("게시물이 존재하지 않습니다.");
      return;
    }

    Map<String, String> params = rq.getParams();

    // 검색 기능 시작
    // articles : 현재 정렬되지 않은 1 ~ 100개의 게시물 리스트
    List<Article> filteredArticles = articles;

    if(params.containsKey("searchKeyword")) {
      String searchKeyword = params.get("searchKeyword");

      filteredArticles = new ArrayList<>();

      for(Article article : articles) {
        boolean matched = article.subject.contains(searchKeyword) || article.content.contains(searchKeyword);

        if(matched) filteredArticles.add(article);
      }
    }

    // 검색 기능 끝

    // 정렬 로직 시작
    boolean orderByIdDesc = true;

    if(params.containsKey("orderBy") && params.get("orderBy").equals("idAsc")) {
      orderByIdDesc = false;
    }

    List<Article> sortedArticles = filteredArticles;

    if(orderByIdDesc) {
      sortedArticles = Util.reverseList(sortedArticles);
    }
    // 정렬 로직 끝

    System.out.println("== 게시물 리스트 ==");
    System.out.println("번호 | 제목");

    sortedArticles.forEach(
        article -> System.out.printf("%d | %s\n", article.id, article.subject)
    );
  }
}
