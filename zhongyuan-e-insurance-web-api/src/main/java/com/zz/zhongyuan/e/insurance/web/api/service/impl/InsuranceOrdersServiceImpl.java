package com.zz.zhongyuan.e.insurance.web.api.service.impl;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.web.api.dao.InsuranceOrdersDao;
import com.zz.zhongyuan.e.insurance.web.api.service.InsuranceOrdersService;

import com.zz.zhongyuan.e.insurance.domain.InsuranceOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * ClassName: InsuranceOrdersServiceImpl
 * Description: <br/>
 * date: 2020/4/21 22:46
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
    public List<InsuranceOrders> getByOuId(Long ouid) {
        return insuranceOrdersDao.getByOuId(ouid);
    }

    @Override
    public BaseResult insertOrder(InsuranceOrders insuranceOrders) {
        if (insuranceOrders.getOrdinaryUsers().getOuid()==null){
            return BaseResult.fail("提交订单失败");
        }
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, 1);
        insuranceOrders.setCreated(date);
        insuranceOrders.setUpdated(cal.getTime());
        insuranceOrders.setState(1);
        insuranceOrdersDao.insertOrder(insuranceOrders);
        return BaseResult.success("订单提交成功");
    }
}
