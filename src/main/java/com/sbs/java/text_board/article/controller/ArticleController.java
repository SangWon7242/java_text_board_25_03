package com.sbs.java.text_board.article.controller;

import com.sbs.java.text_board.article.dto.Article;
import com.sbs.java.text_board.article.service.ArticleService;
import com.sbs.java.text_board.base.Rq;
import com.sbs.java.text_board.board.dto.Board;
import com.sbs.java.text_board.board.service.BoardService;
import com.sbs.java.text_board.container.Container;
import com.sbs.java.text_board.member.dto.Member;

import java.util.List;

public class ArticleController {
  private BoardService boardService;
  private ArticleService articleService;

  public ArticleController() {
    boardService = Container.boardService;
    articleService = Container.articleService;
  }

  public void doWrite(Rq rq) {
    int boardId = rq.getIntParam("boardId", 1);

    Board board = boardService.findByBoardId(boardId);

    System.out.printf("== %s 게시물 작성 ==\n", board.getName());

    String subject;
    String content;


    // 제목 입력
    while (true) {
      System.out.print("제목 : ");
      subject = Container.scanner.nextLine();

      if (subject.trim().isEmpty()) {
        System.out.println("제목을 입력해주세요.");
        continue;
      }

      break;
    }

    // 내용 입력
    while (true) {
      System.out.print("내용 : ");
      content = Container.scanner.nextLine();

      if (content.trim().isEmpty()) {
        System.out.println("내용을 입력해주세요.");
        continue;
      }

      break;
    }

    Member member = (Member) rq.getSessionAttr("loginedMember");

    int memberId = member.getId();
    String writerName = member.getLoginId();

    int id = articleService.save(subject, content, memberId, boardId, writerName);
    System.out.printf("%d번 게시물이 등록되었습니다.\n", id);
  }

  public void showDetail(Rq rq) {
    int id = rq.getIntParam("id", 0);

    if (id == 0) {
      System.out.println("올바른 값을 입력해주세요.");
      return;
    }

    Article article = articleService.findById(id);

    if (article == null) {
      System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
      return;
    }

    Board board = boardService.findByBoardId(article.getBoardId());

    System.out.printf("== %s 게시물 상세보기 ==\n", board.getName());
    System.out.printf("번호 : %d\n", article.getId());
    System.out.printf("제목 : %s\n", article.getSubject());
    System.out.printf("내용 : %s\n", article.getContent());
    System.out.printf("작성자 : %s\n", article.getWriterName());
  }

  public void showList(Rq rq) {
    String searchKeyword = rq.getParam("searchKeyword", "");
    String orderBy = rq.getParam("orderBy", "idDesc");

    List<Article> articles = articleService.findAll(searchKeyword, orderBy);

    if (articles.isEmpty()) {
      System.out.println("게시물이 존재하지 않습니다.");
      return;
    }

    System.out.println("== 게시물 리스트 ==");
    System.out.println("번호 | 제목 | 작성자");

    articles.forEach(
        article ->
            System.out.printf("%d | %s | %s\n", article.getId(), article.getSubject(), article.getWriterName()
            )
    );
  }

  public void doModify(Rq rq) {
    int id = rq.getIntParam("id", 0);

    if (id == 0) {
      System.out.println("올바른 값을 입력해주세요.");
      return;
    }

    Article article = articleService.findById(id);

    if (article == null) {
      System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
      return;
    }

    Member member = (Member) rq.getSessionAttr("loginedMember");

    if(!article.getWriterName().equals(member.getLoginId())) {
      System.out.println("게시물에 대한 접근 권한이 없습니다.");
      return;
    }

    System.out.printf("== %d번 게시물 수정 ==\n", id);

    String subject;
    String content;

    // 제목 입력
    while (true) {
      System.out.print("새 제목 : ");
      subject = Container.scanner.nextLine();

      if (subject.trim().isEmpty()) {
        System.out.println("제목을 입력해주세요.");
        continue;
      }

      break;
    }

    // 내용 입력
    while (true) {
      System.out.print("새 내용 : ");
      content = Container.scanner.nextLine();

      if (content.trim().isEmpty()) {
        System.out.println("내용을 입력해주세요.");
        continue;
      }

      break;
    }

    articleService.modify(id, subject, content);

    System.out.printf("%d번 게시물이 수정되었습니다.\n", article.getId());
  }

  public void doDelete(Rq rq) {
    int id = rq.getIntParam("id", 0);

    if (id == 0) {
      System.out.println("올바른 값을 입력해주세요.");
      return;
    }

    Article article = articleService.findById(id);

    if (article == null) {
      System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
      return;
    }

    Member member = (Member) rq.getSessionAttr("loginedMember");

    if(!article.getWriterName().equals(member.getLoginId())) {
      System.out.println("게시물에 대한 접근 권한이 없습니다.");
      return;
    }

    articleService.remove(id);

    System.out.printf("%d번 게시물을 삭제하였습니다.\n", id);
  }
}
