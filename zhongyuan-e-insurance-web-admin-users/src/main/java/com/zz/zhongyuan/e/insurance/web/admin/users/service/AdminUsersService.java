package com.zz.zhongyuan.e.insurance.web.admin.users.service;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.domain.AdminUsers;

import java.util.List;

/**
 * ClassName: AdminUsersService
 * Description: <br/>
 * date: 2020/2/8 22:28
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public interface AdminUsersService {

    /**
     * 管理员通过邮箱和密码登录
     * @param email
     * @param password
     * @return
     */
    public AdminUsers login(String email,String password);

    /**
     * 注册管理员
     * @param adminUsers
     * @return
     */
    public AdminUsers register(AdminUsers adminUsers);

    /**
     * 查询所有管理员
     * @return
     */
    public List<AdminUsers> selectAll();

    /**
     * 插入管理员信息
     * @param adminUsers
     */
    public BaseResult insert(AdminUsers adminUsers);

    /**
     * 更新信息
     * @param adminUsers
     */
    public void update (AdminUsers adminUsers);

    /**
     * 根据auid查询
     * @param auid
     * @return
     */
    public AdminUsers getById(Long auid);

}
