package project.board.reply.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.board.reply.Reply;
import project.board.reply.ReplyJoinNicknameDto;
import project.board.reply.service.ReplyService;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board/list/{boardId}/reply")
public class ReplyController {

    @Autowired
    ReplyService service;

    @ResponseBody
    @PostMapping
    public ReplyJoinNicknameDto insertReply(
            @RequestBody Reply reply
            ) {
        LocalDateTime date = LocalDateTime.now();
        reply.setReplyCreateDate(date);
        reply.setReplyGroup(service.findGroup() + 1);
        service.insertReply(reply);
        
        int replyId = reply.getReplyId();

        return service.findById(replyId);
    }

    @ResponseBody
    @PostMapping("/nested-reply")
    public ReplyJoinNicknameDto insertNestedReply(
            @RequestBody Reply reply
    ) {
        LocalDateTime date = LocalDateTime.now();
        reply.setReplyCreateDate(date);
        service.insertReply(reply);

        return service.findById(reply.getReplyId());
    }

    @ResponseBody
    @PutMapping
    public String updateReply(@RequestBody Reply reply){
        LocalDateTime date = LocalDateTime.now();
        reply.setReplyUpdateDate(date);
        service.updateReply(reply);

        return "ok";
    }

    @ResponseBody
    @DeleteMapping
    public String deleteReply(@RequestBody Reply reply) {

        service.deleteReply(reply);

        return "ok";
    }

    @ResponseBody
    @GetMapping("/nested-reply/{replyGroup}")
    public List<ReplyJoinNicknameDto> getNestedReply(
            @PathVariable int boardId,
            @PathVariable int replyGroup
    ){
        Reply reply = new Reply();
        reply.setBoardId(boardId);
        reply.setReplyGroup(replyGroup);

        return service.findNestedReply(reply);
    }
}
