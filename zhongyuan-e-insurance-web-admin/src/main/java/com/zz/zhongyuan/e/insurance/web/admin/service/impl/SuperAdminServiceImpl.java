package com.zz.zhongyuan.e.insurance.web.admin.service.impl;

import com.zz.zhongyuan.e.insurance.domain.SuperAdmin;
import com.zz.zhongyuan.e.insurance.web.admin.dao.SuperAdminDao;
import com.zz.zhongyuan.e.insurance.web.admin.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * ClassName: SuperAdminServiceImpl
 * Description: <br/>
 * date: 2020/1/31 23:41
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Service
public class SuperAdminServiceImpl implements SuperAdminService {

    @Autowired
    private SuperAdminDao superAdminDao;

    /**
     * 超级管理员通过手机号和密码登录
     * @param phone
     * @param password
     * @return
     */
    @Override
    public SuperAdmin Login(String phone, String password) {
        SuperAdmin superAdmin = superAdminDao.getByPhone(phone);
        if (superAdmin!=null){
            //明文密码加密
            String md5Password= DigestUtils.md5DigestAsHex(password.getBytes());
            if (md5Password.equals(superAdmin.getPassword())){
                return superAdmin;
            }
        }
        return null;
    }
}
