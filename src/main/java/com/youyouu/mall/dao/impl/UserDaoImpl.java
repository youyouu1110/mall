package com.youyouu.mall.dao.impl;

import com.youyouu.mall.dao.UserDao;
import com.youyouu.mall.model.bean.User;
import com.youyouu.mall.model.bo.user.UpdateUserBO;
import com.youyouu.mall.model.bo.user.UserLoginBO;
import com.youyouu.mall.model.bo.user.UserPwdBO;
import com.youyouu.mall.model.bo.user.UserSignUpBO;
import com.youyouu.mall.model.vo.user.UserSignUpVO;
import com.youyouu.mall.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

    @Override
    public List<User> allUser() {
        List<User> userList = null;
        try {
            userList = queryRunner.query("select * from user", new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void deleteUserById(String id) {
        try {
            queryRunner.update("delete from user where id = ?",id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> searchUserByWord(String word) {
        List<User> userList = null;
        String nickName = "%"+word+"%";
        try {
            userList = queryRunner.query("select * from user where nickname like ?", new BeanListHandler<User>(User.class), nickName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void signUp(UserSignUpBO userSignUpBO) {
        try {
            queryRunner.update("insert into user values(null,?,?,?,?,?,?)",
                    userSignUpBO.getEmail(),userSignUpBO.getNickname(),userSignUpBO.getPwd(),userSignUpBO.getRecipient(),userSignUpBO.getAddress(),userSignUpBO.getPhone());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User login(UserLoginBO loginBO) {
        User user = null;
        try {
            user = queryRunner.query("select * from user where email = ? and pwd = ?", new BeanHandler<User>(User.class),
                    loginBO.getEmail(), loginBO.getPwd());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUserByToken(String token) {
        User user = null;
        try {
            user = queryRunner.query("select * from user where nickname = ?", new BeanHandler<User>(User.class), token);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(UpdateUserBO updateUserBO) {
        try {
            queryRunner.update("update user set nickname = ?, recipient = ?,address = ?,phone = ? where id = ?",
                    updateUserBO.getNickname(),updateUserBO.getRecipient(),updateUserBO.getAddress(),updateUserBO.getPhone(),updateUserBO.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User getUserById(Integer id) {
        User user = null;
        try {
            user = queryRunner.query("select * from user where id = ?", new BeanHandler<User>(User.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updatePwd(UserPwdBO userPwdBO) {
        try {
            queryRunner.update("update user set pwd = ? where id = ?", userPwdBO.getNewPwd(), userPwdBO.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
