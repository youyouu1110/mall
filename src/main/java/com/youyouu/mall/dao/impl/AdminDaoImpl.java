package com.youyouu.mall.dao.impl;

import com.youyouu.mall.dao.AdminDao;
import com.youyouu.mall.model.bean.Admin;
import com.youyouu.mall.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

    QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

    @Override
    public Admin login(Admin admin) {
        Admin query = null;
        try {
             query = queryRunner.query("select * from admin where email = ? and pwd = ?",
                    new BeanHandler<>(Admin.class), admin.getEmail(), admin.getPwd());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public List<Admin> allAdmins() {
        List<Admin> adminList = null;
        try {
            adminList = queryRunner.query("select * from admin",new BeanListHandler<Admin>(Admin.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminList;
    }
}
