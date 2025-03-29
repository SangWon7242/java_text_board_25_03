package com.sbs.java.text_board.container;

import com.sbs.java.text_board.article.controller.ArticleController;
import com.sbs.java.text_board.article.repository.ArticleRepository;
import com.sbs.java.text_board.article.service.ArticleService;
import com.sbs.java.text_board.interceptor.NeedLoginInterceptor;
import com.sbs.java.text_board.interceptor.NeedLogoutInterceptor;
import com.sbs.java.text_board.member.controller.MemberController;
import com.sbs.java.text_board.member.repository.MemberRepository;
import com.sbs.java.text_board.member.service.MemberService;
import com.sbs.java.text_board.session.Session;

import java.util.Scanner;

public class Container {
  public static Scanner scanner;
  public static Session session;

  public static NeedLoginInterceptor needLoginInterceptor;
  public static NeedLogoutInterceptor needLogoutInterceptor;

  public static MemberRepository memberRepository;
  public static ArticleRepository articleRepository;

  public static MemberService memberService;
  public static ArticleService articleService;

  public static MemberController memberController;
  public static ArticleController articleController;
  
  static { // 프로그램 실행시 딱 한번 실행
    scanner = new Scanner(System.in);
    session = new Session();

    needLoginInterceptor = new NeedLoginInterceptor();
    needLogoutInterceptor = new NeedLogoutInterceptor();

    memberRepository = new MemberRepository();
    articleRepository = new ArticleRepository();

    memberService = new MemberService();
    articleService = new ArticleService();

    memberController = new MemberController();
    articleController = new ArticleController();
  }
}
