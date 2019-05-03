package com.myapp.dao;

import com.myapp.model.Login;
import com.myapp.model.User;


public interface UserDao {
    void register(User user);
    User validateUser(Login login);
}