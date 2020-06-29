package com.imooc.service;

import com.imooc.dao.UserDao;
import com.imooc.javabean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    UserDao userDao;

    public User getUser(String userName){
        User user = userDao.getUserByName(userName);
        return user;
    }
}
