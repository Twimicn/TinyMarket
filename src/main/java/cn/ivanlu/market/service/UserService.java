package cn.ivanlu.market.service;

import cn.ivanlu.market.common.ApiResponse;
import cn.ivanlu.market.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUserById(long id);

    User getUserByToken(String token);

    ApiResponse<User> login(String username, String password);

    ApiResponse<User> register(User user);
}
