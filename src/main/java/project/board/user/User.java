package project.board.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class User {
    private String userId;
    private String password;
    private String nickname;
    private LocalDateTime userCreateDate;
    private LocalDateTime userUpdateDate;
}
