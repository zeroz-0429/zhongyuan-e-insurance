package com.zz.zhongyuan.e.insurance.web.api.dao;

import com.zz.zhongyuan.e.insurance.domain.InsuranceOrders;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: InsuranceOrdersDao
 * Description: <br/>
 * date: 2020/4/21 22:40
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Repository
public interface InsuranceOrdersDao {
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
    void insertOrder(InsuranceOrders insuranceOrders);
}
