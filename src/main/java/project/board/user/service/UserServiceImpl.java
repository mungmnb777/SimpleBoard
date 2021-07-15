package project.board.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import project.board.user.SignupDto;
import project.board.user.User;
import org.springframework.stereotype.Service;
import project.board.user.mapper.UserMapper;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper mapper;

    public boolean signUp(SignupDto dto) throws Exception {

        if (mapper.findById(dto.getUserId()) == null && dto.getPassword().equals(dto.getPasswordCheck())) {
            mapper.insertUser(dto);
            return true;
        } else {
            return false;
        }
    }

    public User login(User user) {

        User loginSuccessUser = mapper.getUser(user);

        if(loginSuccessUser != null) {
            return loginSuccessUser;
        } else {
            return null;
        }
    }
}
