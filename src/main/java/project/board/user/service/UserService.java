package project.board.user.service;

import project.board.user.SignupDto;
import project.board.user.User;

public interface UserService {
    boolean signUp(SignupDto dto) throws Exception;
    User login(User user);
}
