package com.zz.zhongyuan.e.insurance.web.admin.users.service.impl;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.dto.PageInfo;
import com.zz.zhongyuan.e.insurance.commons.validator.BeanValidator;
import com.zz.zhongyuan.e.insurance.domain.AdminUsers;
import com.zz.zhongyuan.e.insurance.domain.InsuranceCategory;
import com.zz.zhongyuan.e.insurance.web.admin.users.dao.InsuranceCategoryDao;
import com.zz.zhongyuan.e.insurance.web.admin.users.service.InsuranceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: InsuranceCategoryServiceImpl
 * Description: <br/>
 * date: 2020/2/16 22:42
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

    @Override
    public InsuranceCategory getById(Long icid) {
        return insuranceCategoryDao.getById(icid);
    }


    @Override
    public BaseResult save(InsuranceCategory insuranceCategory) {
        String validator = BeanValidator.validator(insuranceCategory);
        //验证不通过
        if (validator!=null){
            return BaseResult.fail(validator);
        }
        //验证通过
        else {
            insuranceCategory.setUpdated(new Date());
            //新增分类
            if (insuranceCategory.getIcid()==null){
                insuranceCategory.setCreated(new Date());
                insuranceCategoryDao.insert(insuranceCategory);
            }
            //编辑分类
            else {
                update(insuranceCategory);
            }
            return BaseResult.success("保存分类信息成功");
        }
    }

    @Override
    public void delete(Long icid) {
        insuranceCategoryDao.delete(icid);
    }

    @Override
    public void deleteMulti(String[] icids) {
        insuranceCategoryDao.deleteMulti(icids);
    }

    @Override
    public void update(InsuranceCategory insuranceCategory) {
        insuranceCategoryDao.update(insuranceCategory);
    }

    @Override
    public PageInfo<InsuranceCategory> page(int start, int length, int draw, InsuranceCategory insuranceCategory) {
        int count = count(insuranceCategory);

        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", insuranceCategory);

        PageInfo<InsuranceCategory> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(insuranceCategoryDao.page(params));

        return pageInfo;
    }

    @Override
    public int count(InsuranceCategory insuranceCategory) {
        return insuranceCategoryDao.count(insuranceCategory);
    }
}
