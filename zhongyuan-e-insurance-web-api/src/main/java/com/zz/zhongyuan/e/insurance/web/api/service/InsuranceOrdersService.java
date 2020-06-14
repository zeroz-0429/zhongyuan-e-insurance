package com.zz.zhongyuan.e.insurance.web.api.service;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.domain.InsuranceOrders;

import java.util.List;

/**
 * ClassName: InsuranceOrdersService
 * Description: <br/>
 * date: 2020/4/21 22:45
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public interface InsuranceOrdersService {
    /**
     * 根据用户id查询保单
     * @param ouid
     * @return
     */
    List<InsuranceOrders> getByOuId(Long ouid);

    /**
     * 插入用户保单
     * @param insuranceOrders
     */
    BaseResult insertOrder(InsuranceOrders insuranceOrders);
}
