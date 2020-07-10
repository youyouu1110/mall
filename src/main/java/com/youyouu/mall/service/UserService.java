package com.youyouu.mall.service;

import com.youyouu.mall.model.bean.User;
import com.youyouu.mall.model.bo.user.UpdateUserBO;
import com.youyouu.mall.model.bo.user.UserLoginBO;
import com.youyouu.mall.model.bo.user.UserPwdBO;
import com.youyouu.mall.model.bo.user.UserSignUpBO;
import com.youyouu.mall.model.vo.user.UserInfoVO;
import com.youyouu.mall.model.vo.user.UserSignUpVO;

import java.util.List;

public interface UserService {
    List<User> allUser();

    void deleteUserById(String id);

    List<User> searchUserByWord(String word);

    UserSignUpVO signUp(UserSignUpBO userSignUpBO);

    User login(UserLoginBO userLoginBO);

    UserInfoVO getUserByToken(String token);

    void updateUser(UpdateUserBO updateUserBO);

    void updatePwd(UserPwdBO userPwdBO);

    User getUserById(Integer id);
}
