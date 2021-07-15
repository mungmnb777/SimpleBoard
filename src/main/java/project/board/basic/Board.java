package project.board.basic;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Board {
    private int boardId;
    private String title;
    private String content;
    private LocalDateTime boardCreateDate;
    private String userId;
    private LocalDateTime boardUpdateDate;
}
