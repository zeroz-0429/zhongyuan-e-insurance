package com.zz.zhongyuan.e.insurance.web.admin.users.dao;

import com.zz.zhongyuan.e.insurance.domain.AdminUsers;
import com.zz.zhongyuan.e.insurance.domain.OrdinaryUsers;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * ClassName: OrdinaryUsersDao
 * Description: <br/>
 * date: 2020/2/16 21:34
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Repository
public interface OrdinaryUsersDao {
    /**
     * 查询所有
     * @return
     */
    public List<OrdinaryUsers> selectAll();

    /**
     * 根据id查询
     * @param ouid
     * @return
     */
    public OrdinaryUsers getById(Long ouid);


    /**
     * 新增
     * @param ordinaryUsers
     */
    public void insert(OrdinaryUsers ordinaryUsers);


    /**
     * 删除
     * @param ouid
     */
    public void delete(Long ouid);

    /**
     * 批量删除
     * @param ouids
     */
    public void deleteMulti(String[] ouids);


    /**
     * 更新
     * @param ordinaryUsers
     */
    public void update(OrdinaryUsers ordinaryUsers);

    /**
     * 分页查询
     * @param params
     * @return
     */
    public List<OrdinaryUsers> page(Map<String,Object> params);

    /**
     * 查询总数
     * @return
     */
    public int count(OrdinaryUsers ordinaryUsers);
}
