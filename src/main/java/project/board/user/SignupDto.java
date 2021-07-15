package project.board.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SignupDto {
    private String userId;
    private String password;
    private String passwordCheck;
    private String nickname;
    private LocalDateTime userCreateDate;
}
