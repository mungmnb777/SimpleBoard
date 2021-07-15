package project.board.user.mapper;

import org.apache.ibatis.annotations.*;
import project.board.user.SignupDto;
import project.board.user.User;

@Mapper
public interface UserMapper {
    User findById(String userId);
    User getUser(User user);
    void insertUser(SignupDto dto);
}
