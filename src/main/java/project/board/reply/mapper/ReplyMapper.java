package project.board.reply.mapper;

import org.apache.ibatis.annotations.Mapper;
import project.board.reply.Reply;
import project.board.reply.ReplyJoinNicknameDto;

import java.util.List;

@Mapper
public interface ReplyMapper {

    ReplyJoinNicknameDto findById(int replyId);

    Integer findGroup();

    List<Reply> findAll();

    List<ReplyJoinNicknameDto> findAllJoinUser(int boardId);

    int insertReply(Reply reply);

    void deleteReply(int replyId);

    void deleteAll(int boardId);
}
