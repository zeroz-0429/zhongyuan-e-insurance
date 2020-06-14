package com.zz.zhongyuan.e.insurance.web.admin.users.service;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.dto.PageInfo;
import com.zz.zhongyuan.e.insurance.domain.AdminUsers;
import com.zz.zhongyuan.e.insurance.domain.InsuranceCategory;
import com.zz.zhongyuan.e.insurance.domain.OrdinaryUsers;

import java.util.List;

/**
 * ClassName: InsuranceCategoryService
 * Description: <br/>
 * date: 2020/2/16 22:38
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public interface InsuranceCategoryService {
    /**
     * 查询所有管理员信息
     * @return
     */
    public List<InsuranceCategory> selectAll();

    /**
     * 根据id查询
     * @param icid
     * @return
     */
    public InsuranceCategory getById(Long icid);


    /**
     * 新增
     * @param insuranceCategory
     */
    public BaseResult save(InsuranceCategory insuranceCategory);


    /**
     * 删除
     * @param icid
     */
    public void delete(Long icid);

    /**
     * 批量删除
     * @param icids
     */
    public void deleteMulti(String[] icids);

    /**
     * 更新
     * @param insuranceCategory
     */
    public void update(InsuranceCategory insuranceCategory);

    /**
     * 分页查询
     * @param start
     * @param length
     * @return
     */
    public PageInfo<InsuranceCategory> page(int start, int length, int draw, InsuranceCategory insuranceCategory);

    /**
     * 查询总数
     * @return
     */
    public int count(InsuranceCategory insuranceCategory);
}
