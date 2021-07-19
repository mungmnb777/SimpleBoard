package project.board.reply.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.board.reply.Reply;
import project.board.reply.ReplyJoinNicknameDto;
import project.board.reply.mapper.ReplyMapper;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyMapper mapper;

    @Override
    public ReplyJoinNicknameDto findById(int replyId) {
        return mapper.findById(replyId);
    }

    @Override
    public Integer findGroup() {
        Integer result = mapper.findGroup();
        if(result == null) {
            return 0;
        } else {
            return result;
        }
    }

    @Override
    public List<ReplyJoinNicknameDto> findReply(int boardId) {
        return mapper.findReply(boardId);
    }

    @Override
    public List<ReplyJoinNicknameDto> findNestedReply(Reply reply) {
        return mapper.findNestedReply(reply);
    }

    @Override
    public int insertReply(Reply reply) {
        return mapper.insertReply(reply);
    }


    @Override
    public void updateReply(Reply reply) {
        mapper.updateReply(reply);
    }

    @Override
    public void deleteReply(Reply reply) {
            mapper.deleteReply(reply);
    }

    @Override
    public void deleteAll(int boardId) {

        mapper.deleteAll(boardId);
    }
}
