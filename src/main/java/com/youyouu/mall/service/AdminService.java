package com.youyouu.mall.service;

import com.youyouu.mall.model.bean.Admin;
import com.youyouu.mall.model.bo.AdminLoginBO;
<<<<<<< HEAD
=======
import com.youyouu.mall.model.bo.AdminSearchBO;
>>>>>>> temp-branch

import java.util.List;

public interface AdminService {
    Admin login(AdminLoginBO loginBo);

    List<Admin> allAdmins();
<<<<<<< HEAD
=======

    List<Admin> getSearchAdmins(AdminSearchBO searchBO);
>>>>>>> temp-branch
}
