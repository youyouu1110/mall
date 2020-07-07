package com.youyouu.mall.dao;

import com.youyouu.mall.model.bean.Admin;
import com.youyouu.mall.model.bo.admin.AdminBO;

import java.util.List;

public interface AdminDao {
    Admin login(Admin admin);

    List<Admin> allAdmins();

    List<Admin> getSearchAdmins(Admin admin);

    void deleteAdminById(String id);


    Admin getAdminsInfoById(String id);

    void updateAdmin(Admin admin);

    String checkPwd(AdminBO adminBO);

    void changePwd(AdminBO adminBO);
}
