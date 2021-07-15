package project.board.reply;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Reply {
    private int replyId;
    private String content;
    private String userId;
    private int boardId;
    private LocalDateTime replyCreateDate;
    private LocalDateTime replyUpdateDate;
    private int depth;
    private int replyGroup;
}
