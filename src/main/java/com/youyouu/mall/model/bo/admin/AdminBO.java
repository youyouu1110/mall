package com.youyouu.mall.model.bo.admin;

public class AdminBO {
    private String adminToken;
    private String oldPwd;
    private String newPwd;
    private String confirmPwd;

    public String getAdminToken() {
        return adminToken;
    }

    public void setAdminToken(String adminToken) {
        this.adminToken = adminToken;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }

    public AdminBO() {
    }

    public AdminBO(String adminToken, String oldPwd, String newPwd, String confirmPwd) {
        this.adminToken = adminToken;
        this.oldPwd = oldPwd;
        this.newPwd = newPwd;
        this.confirmPwd = confirmPwd;
    }
}
