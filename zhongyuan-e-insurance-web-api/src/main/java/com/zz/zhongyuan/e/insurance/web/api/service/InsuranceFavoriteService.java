package com.zz.zhongyuan.e.insurance.web.api.service;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.domain.InsuranceFavorite;

import java.util.List;

/**
 * ClassName: InsuranceFavoriteService
 * Description: <br/>
 * date: 2020/4/24 20:49
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public interface InsuranceFavoriteService {

    /**
     * 查询所有
     * @return
     */
    List<InsuranceFavorite> selectAll();

    /**
     * 根据用户id查询收藏
     * @param ouid
     * @return
     */
    List<InsuranceFavorite> getByOuId(Long ouid);

    /**
     * 加入收藏
     * @param insuranceFavorite
     */
    BaseResult insert(InsuranceFavorite insuranceFavorite);

    /**
     * 根据id删除收藏
     * @param iid
     */
    BaseResult delete(Long iid,Long ouid);
}
