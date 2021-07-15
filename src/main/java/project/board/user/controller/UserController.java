package project.board.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.board.reply.service.ReplyService;
import project.board.user.SignupDto;
import project.board.user.User;
import project.board.user.service.UserService;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/signup")
    public String signUpForm() {
        return "basic/signup";
    }

    @PostMapping("/signup")
    public String signUp(
            @RequestBody SignupDto dto
    ) throws Exception {
        LocalDateTime date = LocalDateTime.now();

        dto.setUserCreateDate(date);

        boolean signupSuccess = service.signUp(dto);

        if(signupSuccess){
            return "redirect:/";
        } else {
            return "redirect:/user/signup";
        }
    }

    @GetMapping("/login")
    public String loginForm() {
        return "basic/login";
    }

    @PostMapping("/login")
    public String login(
            @RequestBody User user,
            HttpSession session
    ) throws Exception {
        User loginSuccessUser = service.login(user);

        if(loginSuccessUser != null) {
            session.setAttribute("user", loginSuccessUser);
            session.setAttribute("userId", loginSuccessUser.getUserId());
            return "redirect:/";
        } else {
            session.setAttribute("user", null);
            return "redirect:/user/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
