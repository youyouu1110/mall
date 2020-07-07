package com.youyouu.mall.service.impl;

import com.youyouu.mall.dao.AdminDao;
import com.youyouu.mall.dao.impl.AdminDaoImpl;
import com.youyouu.mall.model.bean.Admin;
import com.youyouu.mall.model.bo.admin.AdminBO;
import com.youyouu.mall.model.bo.admin.AdminLoginBO;
import com.youyouu.mall.model.bo.admin.AdminSearchBO;
import com.youyouu.mall.service.AdminService;
import java.util.List;

public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public Admin login(AdminLoginBO loginBo) {
        Admin admin = new Admin();
        admin.setEmail(loginBo.getEmail());
        admin.setPwd(loginBo.getPwd());
        return adminDao.login(admin);
    }

    @Override
    public List<Admin> allAdmins() {
        return adminDao.allAdmins();
    }

    @Override
    public List<Admin> getSearchAdmins(AdminSearchBO searchBO) {
        Admin admin = new Admin();
        admin.setEmail(searchBO.getEmail());
        admin.setNickname(searchBO.getNickname());
        return adminDao.getSearchAdmins(admin);
    }

    @Override
    public void deleteAdminsById(String id) {
        adminDao.deleteAdminById(id);
    }

    @Override
    public Admin getAdminsInfoById(String id) {
        return adminDao.getAdminsInfoById(id);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminDao.updateAdmin(admin);
    }

    @Override
    public String checkPwd(AdminBO adminBO) {
        return adminDao.checkPwd(adminBO);
    }

    @Override
    public void changePwd(AdminBO adminBO) {
        adminDao.changePwd(adminBO);
    }

}
