package com.zz.zhongyuan.e.insurance.web.admin.users.dao;

import com.zz.zhongyuan.e.insurance.domain.InsuranceOrders;
import com.zz.zhongyuan.e.insurance.domain.OrdinaryUsers;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * ClassName: InsuranceOrdersDao
 * Description: <br/>
 * date: 2020/2/16 21:38
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Repository
public interface InsuranceOrdersDao {
    /**
     * 查询所有
     * @return
     */
    public List<InsuranceOrders> selectAll();

    /**
     * 根据id查询
     * @param ioid
     * @return
     */
    public InsuranceOrders getById(Long ioid);

    /**
     * 删除
     * @param ioid
     */
    public void delete(Long ioid);

    /**
     * 批量删除
     * @param ioids
     */
    public void deleteMulti(String[] ioids);


    /**
     * 更新
     * @param insuranceOrders
     */
    public void update(InsuranceOrders insuranceOrders);

    /**
     * 分页查询
     * @param params
     * @return
     */
    public List<InsuranceOrders> page(Map<String,Object> params);

    /**
     * 查询总数
     * @return
     */
    public int count(InsuranceOrders insuranceOrders);
}
