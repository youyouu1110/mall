package com.youyouu.mall.service;

import com.youyouu.mall.model.bean.Admin;
import com.youyouu.mall.model.bo.AdminLoginBO;

import java.util.List;

public interface AdminService {
    Admin login(AdminLoginBO loginBo);

    List<Admin> allAdmins();
}