package project.board.reply.mapper;

import org.apache.ibatis.annotations.Mapper;
import project.board.reply.Reply;
import project.board.reply.ReplyJoinNicknameDto;

import java.util.List;

@Mapper
public interface ReplyMapper {

    ReplyJoinNicknameDto findById(int replyId);

    Integer findGroup();

    List<ReplyJoinNicknameDto> findReply(int boardId);

    List<ReplyJoinNicknameDto> findNestedReply(Reply reply);

    int insertReply(Reply reply);

    void updateReply(Reply reply);

    void deleteReply(Reply reply);

    void deleteAll(int boardId);
}
