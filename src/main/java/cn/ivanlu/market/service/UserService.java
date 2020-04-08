package cn.ivanlu.market.service;

import cn.ivanlu.market.common.ApiResponse;
import cn.ivanlu.market.model.User;

public interface UserService {
    User getUserById(long id);

    ApiResponse<User> login(String username, String password);

    ApiResponse<User> register(User user);
}
