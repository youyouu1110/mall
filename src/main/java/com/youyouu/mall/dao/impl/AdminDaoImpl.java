package com.youyouu.mall.dao.impl;

import com.alibaba.druid.util.StringUtils;
import com.youyouu.mall.dao.AdminDao;
import com.youyouu.mall.model.bean.Admin;
import com.youyouu.mall.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Admin> getSearchAdmins(Admin admin) {
        Map<String,Object> result = getDynamicSql(admin);
        String sql = (String) result.get("sql");
        List<String> params = (List<String>) result.get("params");
        List<Admin> admins = null;
        try {
            admins = queryRunner.query(sql, new BeanListHandler<Admin>(Admin.class), params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }

    private Map<String, Object> getDynamicSql(Admin admin) {
        String sqlBase = "select * from admin where 1 = 1";
        Map<String,Object> map = new HashMap<>();
        List<String> params = new ArrayList<>();
        if(!StringUtils.isEmpty(admin.getEmail())){
            sqlBase += " and email like ? ";
            params.add("%" + admin.getEmail() + "%");
        }
        if(!StringUtils.isEmpty(admin.getNickname())){
            sqlBase += " and nickname like ?";
            params.add("%" + admin.getNickname() + "%");
        }
        map.put("sql",sqlBase);
        map.put("params",params);
        return map;
    }
}
