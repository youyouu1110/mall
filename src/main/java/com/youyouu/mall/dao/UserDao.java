package com.youyouu.mall.dao;

import com.youyouu.mall.model.bean.User;
import com.youyouu.mall.model.bo.user.UpdateUserBO;
import com.youyouu.mall.model.bo.user.UserLoginBO;
import com.youyouu.mall.model.bo.user.UserPwdBO;
import com.youyouu.mall.model.bo.user.UserSignUpBO;
import com.youyouu.mall.model.vo.user.UserSignUpVO;

import java.util.List;

public interface UserDao{
    List<User> allUser();

    void deleteUserById(String id);

    List<User> searchUserByWord(String word);

    void signUp(UserSignUpBO userSignUpBO);

    User login(UserLoginBO loginBO);

    User getUserByToken(String token);

    void updateUser(UpdateUserBO updateUserBO);

    User getUserById(Integer id);

    void updatePwd(UserPwdBO userPwdBO);
}
