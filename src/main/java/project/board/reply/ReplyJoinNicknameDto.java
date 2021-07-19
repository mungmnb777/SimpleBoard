package project.board.reply;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReplyJoinNicknameDto {
    private int replyId;
    private String userId;
    private String content;
    private String nickname;
    private LocalDateTime replyCreateDate;
    private int replyGroup;
    private int depth;
}
