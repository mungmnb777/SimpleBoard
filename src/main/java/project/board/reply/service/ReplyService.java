package project.board.reply.service;

import project.board.reply.Reply;
import project.board.reply.ReplyJoinNicknameDto;

import java.util.List;

public interface ReplyService {

    ReplyJoinNicknameDto findById(int replyId);

    Integer findGroup();

    List<ReplyJoinNicknameDto> findReply(int boardId);

    List<ReplyJoinNicknameDto> findNestedReply(Reply reply);

    int insertReply(Reply reply);

    void updateReply(Reply reply);

    void deleteReply(Reply reply);

    void deleteAll(int boardId);
}
