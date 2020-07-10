package com.youyouu.mall.service.impl;

import com.youyouu.mall.dao.UserDao;
import com.youyouu.mall.dao.impl.UserDaoImpl;
import com.youyouu.mall.model.bean.User;
import com.youyouu.mall.model.bo.user.UpdateUserBO;
import com.youyouu.mall.model.bo.user.UserLoginBO;
import com.youyouu.mall.model.bo.user.UserPwdBO;
import com.youyouu.mall.model.bo.user.UserSignUpBO;
import com.youyouu.mall.model.vo.user.UserInfoVO;
import com.youyouu.mall.model.vo.user.UserSignUpVO;
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

    @Override
    public UserSignUpVO signUp(UserSignUpBO userSignUpBO) {
        userDao.signUp(userSignUpBO);
        UserSignUpVO user = new UserSignUpVO(0,userSignUpBO.getNickname(),userSignUpBO.getNickname());
        return user;
    }

    @Override
    public User login(UserLoginBO loginBO) {
        User user = userDao.login(loginBO);
        return user;
    }

    @Override
    public UserInfoVO getUserByToken(String token) {
        User user = userDao.getUserByToken(token);
        UserInfoVO userInfoVO = new UserInfoVO(0,user.getId(),user.getEmail(),user.getNickname(),user.getRecipient(),user.getAddress(),user.getPhone());
        return userInfoVO;
    }

    @Override
    public void updateUser(UpdateUserBO updateUserBO) {
        userDao.updateUser(updateUserBO);
    }

    @Override
    public void updatePwd(UserPwdBO userPwdBO) {
        userDao.updatePwd(userPwdBO);
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

}
