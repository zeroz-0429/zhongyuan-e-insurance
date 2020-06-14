package com.zz.zhongyuan.e.insurance.web.api.service;

import com.zz.zhongyuan.e.insurance.domain.InsuranceCategory;

import java.util.List;

/**
 * ClassName: InsuranceCategoryService
 * Description: <br/>
 * date: 2020/4/18 23:08
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public interface InsuranceCategoryService {
    /**
     * 查询所有分类
     * @return
     */
    public List<InsuranceCategory> selectAll();
}
