package com.myapp.service;

import com.myapp.model.Login;
import com.myapp.model.User;

public interface UserService {

    User validateUser (Login login);

    User validateUserNameExists (String  username);

    void register(User user);
}
