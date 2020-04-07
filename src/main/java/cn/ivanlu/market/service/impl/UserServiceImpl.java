package cn.ivanlu.market.service.impl;

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
    public User getById(long id) {
        return userDao.getById(id);
    }
}
