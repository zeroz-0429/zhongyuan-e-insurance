package com.zz.zhongyuan.e.insurance.web.admin.service;

import com.zz.zhongyuan.e.insurance.domain.SuperAdmin;

/**
 * ClassName: SuperAdminService
 * Description: <br/>
 * date: 2020/1/31 23:34
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public interface SuperAdminService {
    /**
     * 根超级管理员通过手机号和密码登录
     * @param phone
     * @param password
     * @return
     */
    public SuperAdmin Login(String phone,String password);
}
