package com.zz.zhongyuan.e.insurance.web.admin.dao;

import com.zz.zhongyuan.e.insurance.domain.AdminUsers;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * ClassName: AdminUsersDao
 * Description: <br/>
 * date: 2020/2/1 21:58
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Repository
public interface AdminUsersDao {
    /**
     * 查询所有
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
    public void insert(AdminUsers adminUsers);


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
     * @param params
     * @return
     */
    public List<AdminUsers> page(Map<String,Object> params);

    /**
     * 查询总数
     * @return
     */
    public int count(AdminUsers adminUsers);
}
