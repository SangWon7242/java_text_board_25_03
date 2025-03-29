package com.sbs.java.text_board.member.service;

import com.sbs.java.text_board.container.Container;
import com.sbs.java.text_board.member.dto.Member;
import com.sbs.java.text_board.member.repository.MemberRepository;

public class MemberService {
  private MemberRepository memberRepository;

  public MemberService() {
    memberRepository = Container.memberRepository;
  }

  public void join(String loginId, String loginPw, String name) {
    memberRepository.join(loginId, loginPw, name);
  }

  public Member findByLoginId(String loginId) {
    return memberRepository.findByLoginId(loginId);
  }

  public Member findById(int id) {
    return memberRepository.findById(id);
  }
}
