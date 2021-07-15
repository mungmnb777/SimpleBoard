package project.board.reply.service;

import project.board.reply.Reply;
import project.board.reply.ReplyJoinNicknameDto;

import java.util.List;

public interface ReplyService {

    ReplyJoinNicknameDto findById(int replyId);

    Integer findGroup();

    List<Reply> findAll();

    List<ReplyJoinNicknameDto> findAllJoinUser(int boardId);

    int insertReply(Reply reply);

    void updateReply(Reply reply);

    void deleteReply(int replyId);

    void deleteAll(int boardId);
}
