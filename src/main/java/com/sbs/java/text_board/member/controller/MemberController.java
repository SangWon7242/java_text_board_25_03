package com.sbs.java.text_board.member.controller;

import com.sbs.java.text_board.base.Rq;
import com.sbs.java.text_board.container.Container;
import com.sbs.java.text_board.member.dto.Member;
import com.sbs.java.text_board.member.service.MemberService;

public class MemberController {
  private MemberService memberService;

  public MemberController() {
    memberService = Container.memberService;
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

    memberService.join(loginId, loginPw, name);

    System.out.printf("'%s'님 회원 가입 되었습니다.\n", loginId);
  }

  public void doLogin(Rq rq) {
    String loginId;
    String loginPw;
    Member member;

    System.out.println("== 로그인 ==");

    // 로그인 아이디 입력
    while (true) {
      System.out.print("로그인 아이디 : ");
      loginId = Container.scanner.nextLine();

      if (loginId.trim().isEmpty()) {
        System.out.println("로그인 아이디를 입력해주세요.");
        continue;
      }

      member = memberService.findByLoginId(loginId);

      if(member == null) {
        System.out.println("입력한 로그인 아이디는 존재하지 않습니다.");
        return;
      }

      break;
    }

    int tryLoginPwMaxCount = 3;
    int tryLoginPwCount = 0;

    // 로그인 비번 입력
    while (true) {
      if(tryLoginPwCount >= tryLoginPwMaxCount) {
        System.out.println("비밀번호 틀린 회수를 초과하였습니다.");
        return;
      }

      System.out.print("로그인 비번 : ");
      loginPw = Container.scanner.nextLine();

      if (loginPw.trim().isEmpty()) {
        System.out.println("로그인 비번을 입력해주세요.");
        continue;
      }

      if(!member.getLoginPw().equals(loginPw)) {
        tryLoginPwCount++;

        System.out.println("비밀번호가 일치하지 않습니다.");
        System.out.printf("비밀번호 틀릭 횟수(%d / %d)\n", tryLoginPwCount, tryLoginPwMaxCount);
        continue;
      }

      break;
    }

    System.out.printf("'%s'님 로그인 되었습니다.\n", loginId);
  }
}
