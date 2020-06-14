package com.zz.zhongyuan.e.insurance.web.api.service.impl;

import com.zz.zhongyuan.e.insurance.domain.Insurance;
import com.zz.zhongyuan.e.insurance.domain.InsuranceCategory;
import com.zz.zhongyuan.e.insurance.web.api.dao.InsuranceDao;
import com.zz.zhongyuan.e.insurance.web.api.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: InsuranceServiceImpl
 * Description: <br/>
 * date: 2020/4/17 23:35
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Service
public class InsuranceServiceImpl implements InsuranceService {
    @Autowired
    private InsuranceDao insuranceDao;
    @Override
    public List<Insurance> selectByCategoryId(Long categoryId) {
        InsuranceCategory insuranceCategory = new InsuranceCategory();
        insuranceCategory.setIcid(categoryId);
        Insurance insurance = new Insurance();
        insurance.setInsuranceCategory(insuranceCategory);
        return insuranceDao.selectByCategoryId(insurance);
    }

    @Override
    public List<Insurance> getById(Long iid) {
        return insuranceDao.getById(iid);
    }

    @Override
    public List<Insurance> getByName(String name) {
        return insuranceDao.getByName(name);
    }

    @Override
    public List<Insurance> getByActivity() {
        return insuranceDao.getByActivity();
    }
}
