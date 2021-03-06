package com.zz.zhongyuan.e.insurance.web.api.service;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.domain.OrdinaryUsers;

import java.util.List;

/**
 * ClassName: OrdinaryUsersService
 * Description: <br/>
 * date: 2020/3/19 20:22
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */

public interface OrdinaryUsersService {
    /**
     * 登录
     * @param ordinaryUsers
     * @return
     */
    OrdinaryUsers login(OrdinaryUsers ordinaryUsers);

    /**
     * 注册
     * @param ordinaryUsers
     */
    BaseResult register(OrdinaryUsers ordinaryUsers);

    /**
     * 查询所有
     * @return
     */
    List<OrdinaryUsers> selectAll();
    /**
     * 根据id查询用户信息
     * @param ouid
     * @return
     */
    OrdinaryUsers getById(Long ouid);

    /**
     * 更新
     * @param ordinaryUsers
     */
    public BaseResult update(OrdinaryUsers ordinaryUsers);
}
