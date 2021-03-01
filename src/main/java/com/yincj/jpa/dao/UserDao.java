package com.yincj.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.yincj.jpa.entity.User;

@Component
public interface UserDao extends JpaRepository<User,Long> {

}
