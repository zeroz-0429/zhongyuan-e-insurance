package com.zz.zhongyuan.e.insurance.web.admin.service;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.dto.PageInfo;
import com.zz.zhongyuan.e.insurance.domain.AdminUsers;
import java.util.List;


/**
 * ClassName: AdminUsersService
 * Description: <br/>
 * date: 2020/2/1 22:37
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public interface AdminUsersService {
    /**
     * 查询所有管理员信息
     * @return
     */
    public List<AdminUsers> selectAll();

    /**
     * 根据id查询
     * @param auid
     * @return
     */
    public AdminUsers getById(Long auid);

    /**
     * 新增
     * @param adminUsers
     */
    public BaseResult save(AdminUsers adminUsers);


    /**
     * 删除
     * @param auid
     */
    public void delete(Long auid);

    /**
     * 批量删除
     * @param auids
     */
    public void deleteMulti(String[] auids);

    /**
     * 更新
     * @param adminUsers
     */
    public void update(AdminUsers adminUsers);

    /**
     * 分页查询
     * @param start
     * @param length
     * @return
     */
    public PageInfo<AdminUsers> page(int start, int length, int draw, AdminUsers adminUsers);

    /**
     * 查询总数
     * @return
     */
    public int count(AdminUsers adminUsers);
}
