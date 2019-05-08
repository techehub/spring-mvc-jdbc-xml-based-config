package com.myapp.service;

import com.myapp.dao.UserDao;
import com.myapp.model.Login;
import com.myapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserServiceImpl implements  UserService{

    @Autowired
    UserDao userDao;

    @Override
    public User validateUser(Login login) {
        return userDao.validateUser(login);
    }

    @Override
    public void register(User user) {
        userDao.register(user);
    }
}
