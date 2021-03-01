package com.yincj.jpa.service.impl;

import com.yincj.jpa.dao.UserDao;
import com.yincj.jpa.entity.User;
import com.yincj.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDAO;
    @Override
    public List<User> findAll() {
        return null;
    }
}
