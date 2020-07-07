package com.youyouu.mall.service.impl;

import com.youyouu.mall.dao.UserDao;
import com.youyouu.mall.dao.impl.UserDaoImpl;
import com.youyouu.mall.model.bean.User;
import com.youyouu.mall.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> allUser() {
        return userDao.allUser();
    }

    @Override
    public void deleteUserById(String id) {
        userDao.deleteUserById(id);
    }

    @Override
    public List<User> searchUserByWord(String word) {
        return userDao.searchUserByWord(word);
    }


}
