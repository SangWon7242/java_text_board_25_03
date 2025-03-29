package com.sbs.java.text_board.board.service;

import com.sbs.java.text_board.board.dto.Board;
import com.sbs.java.text_board.board.repository.BoardRepository;
import com.sbs.java.text_board.container.Container;

public class BoardService {
  private BoardRepository boardRepository;

  public BoardService() {
    boardRepository = Container.boardRepository;
  }

  public Board findByBoardId(int boardId) {
    return boardRepository.findByBoardId(boardId);
  }
}
