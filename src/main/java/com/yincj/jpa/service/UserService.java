package com.yincj.jpa.service;

import com.yincj.jpa.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
