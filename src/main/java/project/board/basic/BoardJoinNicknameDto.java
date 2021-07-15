package project.board.basic;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardJoinNicknameDto {
    private int boardId;
    private String title;
    private LocalDateTime boardCreateDate;
    private String nickname;
}
