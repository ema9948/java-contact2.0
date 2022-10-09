package com.Cristian.login.dao;

import com.Cristian.login.models.User;

public interface UserDao {

    User login(User user);
    Boolean register(User user);
}
