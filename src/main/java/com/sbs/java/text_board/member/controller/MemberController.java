package com.sbs.java.text_board.member.controller;

import com.sbs.java.text_board.base.Rq;
import com.sbs.java.text_board.container.Container;
import com.sbs.java.text_board.member.dto.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberController {
  private List<Member> members;
  private int lastId;

  public MemberController() {
    members = new ArrayList<>();
    lastId = 0;
  }

  public void doJoin(Rq rq) {
    String loginId;
    String loginPw;
    String loginPwConfirm;
    String name;

    System.out.println("== 회원 가입 ==");

    // 로그인 아이디 입력
    while (true) {
      System.out.print("로그인 아이디 : ");
      loginId = Container.scanner.nextLine();

      if (loginId.trim().isEmpty()) {
        System.out.println("로그인 아이디를 입력해주세요.");
        continue;
      }

      break;
    }

    // 로그인 비번 입력
    while (true) {
      System.out.print("로그인 비번 : ");
      loginPw = Container.scanner.nextLine();

      if (loginPw.trim().isEmpty()) {
        System.out.println("로그인 비번을 입력해주세요.");
        continue;
      }
      
      while (true) {
        System.out.print("로그인 비번 확인 : ");
        loginPwConfirm = Container.scanner.nextLine();

        if (loginPwConfirm.trim().isEmpty()) {
          System.out.println("로그인 비번 확인을 입력해주세요.");
          continue;
        }

        if(!loginPwConfirm.equals(loginPw)) {
          System.out.println("로그인 비번이 일치하지 않습니다.");
          continue;
        }

        break;
      }

      break;
    }

    // 이름 입력
    while (true) {
      System.out.print("이름 : ");
      name = Container.scanner.nextLine();

      if (name.trim().isEmpty()) {
        System.out.println("이름을 입력해주세요.");
        continue;
      }

      break;
    }

    int id = ++lastId;

    Member member = new Member(id, loginId, loginPw, name);

    members.add(member);

    System.out.printf("'%s'님 회원 가입 되었습니다.\n", member.getLoginId());
  }
}
