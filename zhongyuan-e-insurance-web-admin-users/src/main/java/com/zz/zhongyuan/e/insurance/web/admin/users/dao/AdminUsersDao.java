package com.zz.zhongyuan.e.insurance.web.admin.users.dao;

import com.zz.zhongyuan.e.insurance.domain.AdminUsers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: AdminUsersDao
 * Description: <br/>
 * date: 2020/2/8 22:19
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Repository
public interface AdminUsersDao {

    /**
     * 根据邮箱查找管理员
     * @param email
     * @return
     */
    public AdminUsers getByEmail(String email);

    /**
     * 插入管理员信息
     * @param adminUsers
     */
    public void insert(AdminUsers adminUsers);

    /**
     * 查询所有管理员
     * @return
     */
    public List<AdminUsers> selectAll();

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
