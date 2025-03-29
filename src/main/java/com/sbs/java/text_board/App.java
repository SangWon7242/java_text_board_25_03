package com.sbs.java.text_board;

import com.sbs.java.text_board.article.controller.ArticleController;
import com.sbs.java.text_board.base.Rq;
import com.sbs.java.text_board.container.Container;
import com.sbs.java.text_board.interceptor.Interceptor;
import com.sbs.java.text_board.member.controller.MemberController;
import com.sbs.java.text_board.member.dto.Member;
import com.sbs.java.text_board.session.Session;

import java.util.ArrayList;
import java.util.List;

public class App {
  public MemberController memberController;
  public ArticleController articleController;
  public Session session;

  public App() {
    memberController = Container.memberController;
    articleController = Container.articleController;

    session = Container.session;
  }

  public void run() {
    System.out.println("== JAVA 텍스트 게시판 구현 ==");

    while (true) {
      Rq rq = new Rq();

      Member member = (Member) rq.getSessionAttr("loginedMember");

      String promptName = "명령어";

      if(member != null) {
        promptName = member.getLoginId();
      }

      System.out.printf("%s) ", promptName);
      String cmd = Container.scanner.nextLine();

      rq.setCommand(cmd);
      
      if(!runInterceptor(rq)) {
        continue;
      }

      if (rq.getUrlPath().equals("/usr/article/write")) {
        articleController.doWrite(rq);
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
      } else if (rq.getUrlPath().equals("/usr/member/login")) {
        memberController.doLogin(rq);
      } else if (rq.getUrlPath().equals("/usr/member/logout")) {
        memberController.doLogout(rq);
      } else if (rq.getUrlPath().equals("/usr/member/mypage")) {
        memberController.showMyPage(rq);
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

  private boolean runInterceptor(Rq rq) {
    List<Interceptor> interceptors = new ArrayList<>();

    interceptors.add(Container.needLoginInterceptor);
    interceptors.add(Container.needLogoutInterceptor);

    for(Interceptor interceptor : interceptors) {
      if(!interceptor.run(rq)) {
        return false;
      }
    }

    return true;
  }
}
