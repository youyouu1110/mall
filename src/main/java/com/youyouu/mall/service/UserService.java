package com.youyouu.mall.service;

import com.youyouu.mall.model.bean.User;
import java.util.List;

public interface UserService {
    List<User> allUser();

    void deleteUserById(String id);

    List<User> searchUserByWord(String word);

}
