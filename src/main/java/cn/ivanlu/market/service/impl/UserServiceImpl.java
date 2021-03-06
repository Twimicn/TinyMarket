package cn.ivanlu.market.service.impl;

import cn.ivanlu.market.common.ApiResponse;
import cn.ivanlu.market.dao.UserDao;
import cn.ivanlu.market.model.User;
import cn.ivanlu.market.service.UserService;
import cn.ivanlu.market.util.MD5;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    private String generateToken(String username) {
        return MD5.encode("BUNNY_" + Math.random() + "$" + username);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByToken(String token) {
        User user = userDao.getUserByToken(token);
        if (user != null) {
            if ((new Date()).after(user.getExpire())) {
                return null;
            }
        }
        return user;
    }

    @Override
    public int count() {
        return userDao.count();
    }

    @Override
    public List<User> getUsersByPage(int page, int size) {
        return userDao.getUsersByPage((page - 1) * size, size);
    }

    @Override
    public ApiResponse<User> login(String username, String password) {
        User user = userDao.getUserByUsername(username);
        if (user == null) {
            return ApiResponse.<User>builder().status(1002).msg("用户不存在").build();
        }
        if (!user.getPassword().equals(MD5.encode(password))) {
            return ApiResponse.<User>builder().status(1001).msg("密码错误").build();
        }
        if (null == user.getExpire() || (new Date()).after(user.getExpire())) {
            user.setExpire(new Date(System.currentTimeMillis() + 86400000L));
            user.setToken(generateToken(user.getUsername()));
        }
        user.setUpdateTime(new Date());
        if (userDao.updateToken(user) > 0) {
            return ApiResponse.<User>builder().status(0).msg("ok").data(user).build();
        } else {
            return ApiResponse.<User>builder().status(-6).msg("数据库出错").build();
        }
    }

    @Override
    public ApiResponse<User> register(User user) {
        User u = userDao.getUserByUsername(user.getUsername());
        if (u != null) {
            return ApiResponse.<User>builder().status(1003).msg("用户名已存在").build();
        }
        user.setPassword(MD5.encode(user.getPassword()));
        user.setExpire(new Date(System.currentTimeMillis() + 86400000L));
        user.setToken(generateToken(user.getUsername()));
        long uid = userDao.create(user);
        if (uid <= 0) {
            return ApiResponse.<User>builder().status(-6).msg("数据库出错").build();
        }
        return ApiResponse.<User>builder().status(0).msg("ok").data(user).build();
    }
}
