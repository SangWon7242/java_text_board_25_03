package com.sbs.java.text_board;

import com.sbs.java.text_board.article.controller.ArticleController;
import com.sbs.java.text_board.base.Rq;
import com.sbs.java.text_board.container.Container;
import com.sbs.java.text_board.member.controller.MemberController;

public class App {
  public MemberController memberController;
  public ArticleController articleController;

  public App() {
    memberController = Container.memberController;
    articleController = Container.articleController;
  }

  public void run() {
    System.out.println("== JAVA 텍스트 게시판 구현 ==");

    while (true) {
      System.out.print("명령어) ");
      String cmd = Container.scanner.nextLine();

      Rq rq = new Rq(cmd);

      if (rq.getUrlPath().equals("/usr/article/write")) {
        articleController.doWrite();
      } else if (rq.getUrlPath().equals("/usr/article/detail")) {
        articleController.showDetail(rq);
      } else if (rq.getUrlPath().equals("/usr/article/list")) {
        articleController.showList(rq);
      } else if (rq.getUrlPath().equals("/usr/article/modify")) {
        articleController.doModify(rq);
      } else if (rq.getUrlPath().equals("/usr/article/delete")) {
        articleController.doDelete(rq);
      } else if (rq.getUrlPath().equals("/usr/member/join")) {
        memberController.doJoin(rq);
      } else if (rq.getUrlPath().equals("exit")) {
        System.out.println("게시판 프로그램을 종료합니다.");
        break;
      } else {
        System.out.println("명령어를 잘 못 입력하였습니다.");
      }
    }

    System.out.println("== JAVA 텍스트 게시판 종료 ==");
    Container.scanner.close();
  }
}
