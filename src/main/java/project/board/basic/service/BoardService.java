package project.board.basic.service;

import project.board.basic.Board;
import project.board.basic.BoardJoinNicknameDto;

import java.util.List;

public interface BoardService {

    List<Board> findAll();

    List<BoardJoinNicknameDto> findAllJoinUser();

    Board findById(int boardId);

    void insertBoard(Board board);

    void updateBoard(Board board);

    void deleteBoard(int boardId);
}