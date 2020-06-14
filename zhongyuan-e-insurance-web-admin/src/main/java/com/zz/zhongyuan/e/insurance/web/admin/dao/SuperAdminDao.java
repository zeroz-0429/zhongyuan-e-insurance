package com.zz.zhongyuan.e.insurance.web.admin.dao;

import com.zz.zhongyuan.e.insurance.domain.SuperAdmin;
import org.springframework.stereotype.Repository;

/**
 * ClassName: SuperAdminDao
 * Description: <br/>
 * date: 2020/1/31 15:27
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Repository
public interface SuperAdminDao {

    /**
     * 根据手机号查找超级管理员
     * @param phone
     * @return
     */
    public SuperAdmin getByPhone(String phone);
}
