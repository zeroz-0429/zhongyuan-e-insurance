package com.zz.zhongyuan.e.insurance.web.admin.users.service.impl;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.dto.PageInfo;
import com.zz.zhongyuan.e.insurance.commons.validator.BeanValidator;
import com.zz.zhongyuan.e.insurance.domain.AdminUsers;
import com.zz.zhongyuan.e.insurance.domain.InsuranceOrders;
import com.zz.zhongyuan.e.insurance.web.admin.users.dao.InsuranceOrdersDao;
import com.zz.zhongyuan.e.insurance.web.admin.users.service.InsuranceOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: InsuranceOrdersServiceImpl
 * Description: <br/>
 * date: 2020/2/16 22:43
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Service
public class InsuranceOrdersServiceImpl implements InsuranceOrdersService {

    @Autowired
    private InsuranceOrdersDao insuranceOrdersDao;

    @Override
    public List<InsuranceOrders> selectAll() {
        return insuranceOrdersDao.selectAll();
    }

    @Override
    public InsuranceOrders getById(Long ioid) {
        return insuranceOrdersDao.getById(ioid);
    }

    @Override
    public BaseResult save(InsuranceOrders insuranceOrders) {
        String validator = BeanValidator.validator(insuranceOrders);
        //验证不通过
        if (validator!=null){
            return BaseResult.fail(validator);
        }
        //验证通过
        else {
            //编辑用户
            insuranceOrders.setUpdated(new Date());
            update(insuranceOrders);
            return BaseResult.success("保存普通用户信息成功");
        }
    }

    @Override
    public void delete(Long ioid) {
        insuranceOrdersDao.delete(ioid);
    }

    @Override
    public void deleteMulti(String[] ioids) {
        insuranceOrdersDao.deleteMulti(ioids);
    }

    @Override
    public void update(InsuranceOrders insuranceOrders) {
        insuranceOrdersDao.update(insuranceOrders);
    }

    @Override
    public PageInfo<InsuranceOrders> page(int start, int length, int draw, InsuranceOrders insuranceOrders) {
        int count = count(insuranceOrders);

        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", insuranceOrders);

        PageInfo<InsuranceOrders> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(insuranceOrdersDao.page(params));

        return pageInfo;
    }

    @Override
    public int count(InsuranceOrders insuranceOrders) {
        return insuranceOrdersDao.count(insuranceOrders);
    }
}
