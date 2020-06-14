package com.zz.zhongyuan.e.insurance.web.api.service.impl;

import com.zz.zhongyuan.e.insurance.domain.InsuranceCategory;
import com.zz.zhongyuan.e.insurance.web.api.dao.InsuranceCategoryDao;
import com.zz.zhongyuan.e.insurance.web.api.service.InsuranceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: InsuranceCategoryServiceImpl
 * Description: <br/>
 * date: 2020/4/18 23:09
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Service
public class InsuranceCategoryServiceImpl implements InsuranceCategoryService {
    @Autowired
    private InsuranceCategoryDao insuranceCategoryDao;
    @Override
    public List<InsuranceCategory> selectAll() {
        return insuranceCategoryDao.selectAll();
    }
}
