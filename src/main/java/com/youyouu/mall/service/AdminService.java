package com.youyouu.mall.service;

import com.youyouu.mall.model.bean.Admin;
import com.youyouu.mall.model.bo.admin.AdminBO;
import com.youyouu.mall.model.bo.admin.AdminLoginBO;
import com.youyouu.mall.model.bo.admin.AdminSearchBO;


import java.util.List;

public interface AdminService {
    Admin login(AdminLoginBO loginBo);

    List<Admin> allAdmins();

    List<Admin> getSearchAdmins(AdminSearchBO searchBO);

    void deleteAdminsById(String id);


    Admin getAdminsInfoById(String id);

    void updateAdmin(Admin admin);


    String checkPwd(AdminBO adminBO);

    void changePwd(AdminBO adminBO);
}
