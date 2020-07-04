package com.youyouu.mall.dao;

import com.youyouu.mall.model.bean.Admin;

import java.util.List;

public interface AdminDao {
    Admin login(Admin admin);

    List<Admin> allAdmins();
<<<<<<< HEAD
=======

    List<Admin> getSearchAdmins(Admin admin);
>>>>>>> temp-branch
}
