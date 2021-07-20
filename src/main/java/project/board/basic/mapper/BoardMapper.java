package project.board.basic.mapper;

import org.apache.ibatis.annotations.Mapper;
import project.board.basic.Board;
import project.board.basic.BoardJoinNicknameDto;
import project.board.basic.BoardPaging;

import java.util.List;

@Mapper
public interface BoardMapper {
    int findAllCnt();
    List<Board> findAll();
    List<BoardJoinNicknameDto> findAllJoinUser(BoardPaging paging);
    Board findById(int boardId);
    void insertBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(int boardId);
}
