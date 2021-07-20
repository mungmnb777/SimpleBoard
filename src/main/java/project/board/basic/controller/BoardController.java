package project.board.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.board.basic.Board;
import project.board.basic.BoardPaging;
import project.board.basic.service.BoardService;
import project.board.reply.service.ReplyService;
import project.board.user.User;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Slf4j
@Controller
@RequestMapping
public class BoardController {

    @Autowired
    BoardService service;

    @Autowired
    ReplyService replyService;

    @GetMapping
    public String init(Model model, @RequestParam(defaultValue = "1") int page) {

        int totalPostCnt = service.findAllCnt();

        BoardPaging paging = new BoardPaging(totalPostCnt, page);

        model.addAttribute("boardList", service.findAllJoinUser(paging));
        model.addAttribute("paging", paging);

        return "basic/index";
    }

    @GetMapping("/board/list/{boardId}")
    public String getContent(@PathVariable int boardId, Model model) {

        model.addAttribute("board", service.findById(boardId));
        model.addAttribute("replyList", replyService.findReply(boardId));

        return "basic/board";
    }

    @GetMapping("/board/add")
    public String getAddForm() {
        return "basic/addForm";
    }

    @PostMapping("/board/add")
    public String insertContent(
            @RequestParam String title,
            @RequestParam String content,
            HttpSession session
    ) {
        Board board = new Board();

        LocalDateTime date = LocalDateTime.now();

        User user = (User) session.getAttribute("user");

        board.setTitle(title);
        board.setContent(content);
        board.setBoardCreateDate(date);
        board.setUserId(user.getUserId());

        service.insertBoard(board);

        return "redirect:/";
    }

    @GetMapping("/board/list/{boardId}/edit")
    public String getEditForm(
            @PathVariable int boardId,
            Model model
    ) {
        model.addAttribute("board", service.findById(boardId));
        return "basic/editForm";
    }

    @PutMapping("/board/list/{boardId}/edit")
    public String updateContent(
            @PathVariable int boardId,
            @RequestBody Board board,
            HttpSession session
    ) {
        LocalDateTime date = LocalDateTime.now();
        board.setBoardId(boardId);
        board.setBoardUpdateDate(date);

        if(session.getAttribute("user") != null) {
            service.updateBoard(board);
        }
        return "redirect:/";
    }

    @DeleteMapping("/board/list/{boardId}")
    public String deleteContent(
            @PathVariable int boardId
    ) {
        service.deleteBoard(boardId);
        replyService.deleteAll(boardId);
        return "redirect:/";
    }
}
