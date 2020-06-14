package com.zz.zhongyuan.e.insurance.web.admin.users.service;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.dto.PageInfo;
import com.zz.zhongyuan.e.insurance.domain.AdminUsers;
import com.zz.zhongyuan.e.insurance.domain.InsuranceOrders;
import com.zz.zhongyuan.e.insurance.domain.OrdinaryUsers;

import java.util.List;

/**
 * ClassName: InsuranceOrdersService
 * Description: <br/>
 * date: 2020/2/16 22:40
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public interface InsuranceOrdersService {
    /**
     * 查询所有信息
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
     * 新增
     * @param insuranceOrders
     */
    public BaseResult save(InsuranceOrders insuranceOrders);


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
     * @param start
     * @param length
     * @return
     */
    public PageInfo<InsuranceOrders> page(int start, int length, int draw, InsuranceOrders insuranceOrders);

    /**
     * 查询总数
     * @return
     */
    public int count(InsuranceOrders insuranceOrders);
}
