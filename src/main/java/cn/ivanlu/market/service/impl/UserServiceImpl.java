package cn.ivanlu.market.service.impl;

import cn.ivanlu.market.common.ApiResponse;
import cn.ivanlu.market.dao.UserDao;
import cn.ivanlu.market.model.User;
import cn.ivanlu.market.service.UserService;
import cn.ivanlu.market.util.MD5;
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
            if (user.getPassword().equals(MD5.encode(password))) {
                return ApiResponse.<User>builder().status(0).msg("ok").data(user).build();
            } else {
                return ApiResponse.<User>builder().status(1001).msg("密码错误").build();
            }
        } else {
            return ApiResponse.<User>builder().status(1002).msg("用户不存在").build();
        }
    }

    @Override
    public ApiResponse<User> register(User user) {
        User u = userDao.getUserByUsername(user.getUsername());
        if (u != null) {
            return ApiResponse.<User>builder().status(1003).msg("用户名已存在").build();
        }
        user.setPassword(MD5.encode(user.getPassword()));
        long uid = userDao.create(user);
        if (uid <= 0) {
            return ApiResponse.<User>builder().status(-6).msg("数据库出错").build();
        }
        return ApiResponse.<User>builder().status(0).msg("ok").data(user).build();
    }
}
