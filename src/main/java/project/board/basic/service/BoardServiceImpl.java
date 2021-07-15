package project.board.basic.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.board.basic.Board;
import project.board.basic.BoardJoinNicknameDto;
import project.board.basic.mapper.BoardMapper;

import java.util.List;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper mapper;

    public List<Board> findAll() {
        return mapper.findAll();
    }

    public List<BoardJoinNicknameDto> findAllJoinUser() { return mapper.findAllJoinUser(); }

    public Board findById(int boardId) {
        return mapper.findById(boardId);
    }

    public void insertBoard(Board board) {
        mapper.insertBoard(board);
    }

    public void updateBoard(Board board) {
        mapper.updateBoard(board);
    }

    public void deleteBoard(int boardId) {
        mapper.deleteBoard(boardId);
    }
}
