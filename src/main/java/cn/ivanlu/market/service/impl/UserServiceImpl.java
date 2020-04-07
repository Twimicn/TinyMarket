package cn.ivanlu.market.service.impl;

import cn.ivanlu.market.common.ApiResponse;
import cn.ivanlu.market.dao.UserDao;
import cn.ivanlu.market.model.User;
import cn.ivanlu.market.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public ApiResponse<User> login(String username, String password) {
        User user = userDao.getUserByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return ApiResponse.<User>builder().status(0).msg("ok").data(user).build();
            } else {
                return ApiResponse.<User>builder().status(1001).msg("密码错误").build();
            }
        } else {
            return ApiResponse.<User>builder().status(1002).msg("用户不存在").build();
        }
    }

    @Override
    public int register(User user) {
        return 0;
    }
}
