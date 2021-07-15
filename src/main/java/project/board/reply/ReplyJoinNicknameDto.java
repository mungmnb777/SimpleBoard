package project.board.reply;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyJoinNicknameDto {
    private int replyId;
    private String userId;
    private String content;
    private String nickname;
    private int replyGroup;
    private int depth;
}
