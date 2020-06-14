package com.zz.zhongyuan.e.insurance.web.admin.users.dao;

import com.zz.zhongyuan.e.insurance.domain.InsuranceCategory;
import com.zz.zhongyuan.e.insurance.domain.OrdinaryUsers;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * ClassName: InsuranceCategoryDao
 * Description: <br/>
 * date: 2020/2/16 21:37
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Repository
public interface InsuranceCategoryDao {
    /**
     * 查询所有保险分类信息
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
    public void insert(InsuranceCategory insuranceCategory);


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
     * @param params
     * @return
     */
    public List<InsuranceCategory> page(Map<String,Object> params);

    /**
     * 查询总数
     * @return
     */
    public int count(InsuranceCategory insuranceCategory);
}
