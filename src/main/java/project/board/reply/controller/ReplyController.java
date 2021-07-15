package project.board.reply.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.board.reply.Reply;
import project.board.reply.ReplyJoinNicknameDto;
import project.board.reply.service.ReplyService;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequestMapping("/board/list/{boardId}/reply")
public class ReplyController {

    @Autowired
    ReplyService service;

    @ResponseBody
    @PostMapping
    public ReplyJoinNicknameDto insertReply(
            @PathVariable int boardId,
            @RequestBody Reply reply
            ) {
        LocalDateTime date = LocalDateTime.now();
        reply.setReplyCreateDate(date);
        reply.setBoardId(boardId);
        reply.setReplyGroup(service.findGroup() + 1);
        service.insertReply(reply);
        
        int replyId = reply.getReplyId();

        return service.findById(replyId);
    }

    @ResponseBody
    @DeleteMapping
    public String deleteReply(@RequestBody Reply reply) {
        int replyId = reply.getReplyId();

        service.deleteReply(replyId);

        return "ok";
    }
}
