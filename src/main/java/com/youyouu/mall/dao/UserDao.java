package com.youyouu.mall.dao;

import com.youyouu.mall.model.bean.User;
import java.util.List;

public interface UserDao{
    List<User> allUser();

    void deleteUserById(String id);

    List<User> searchUserByWord(String word);


}
