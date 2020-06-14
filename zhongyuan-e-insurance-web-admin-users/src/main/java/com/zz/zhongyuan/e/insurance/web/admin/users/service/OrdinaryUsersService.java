package com.zz.zhongyuan.e.insurance.web.admin.users.service;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.dto.PageInfo;
import com.zz.zhongyuan.e.insurance.domain.AdminUsers;
import com.zz.zhongyuan.e.insurance.domain.OrdinaryUsers;
import java.util.List;

/**
 * ClassName: OrdinaryUsersService
 * Description: <br/>
 * date: 2020/2/16 22:41
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public interface OrdinaryUsersService {
    /**
     * 查询所有管理员信息
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
    public BaseResult save(OrdinaryUsers ordinaryUsers);


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
     * @param start
     * @param length
     * @return
     */
    public PageInfo<OrdinaryUsers> page(int start, int length, int draw, OrdinaryUsers ordinaryUsers);

    /**
     * 查询总数
     * @return
     */
    public int count(OrdinaryUsers ordinaryUsers);
}
