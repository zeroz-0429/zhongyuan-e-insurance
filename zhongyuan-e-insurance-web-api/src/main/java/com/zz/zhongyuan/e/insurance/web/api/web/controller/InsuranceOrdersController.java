package com.zz.zhongyuan.e.insurance.web.api.web.controller;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.domain.InsuranceOrders;
import com.zz.zhongyuan.e.insurance.web.api.service.InsuranceOrdersService;
import com.zz.zhongyuan.e.insurance.web.api.web.dto.InsuranceOrdersDTO;
import com.zz.zhongyuan.e.insurance.web.api.web.dto.OrdinaryUsersDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: InsuranceOrdersController
 * Description: <br/>
 * date: 2020/4/21 22:48
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@RestController
@RequestMapping(value = "/api/insurance/order")
public class InsuranceOrdersController {
    @Autowired
    private InsuranceOrdersService insuranceOrdersService;

    /**
     * 保险列表接口
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public BaseResult list(Long ouid) {
        List<InsuranceOrdersDTO> insuranceOrdersDTOS = null;
        List<InsuranceOrders> insuranceOrders = insuranceOrdersService.getByOuId(ouid);
        if (insuranceOrders != null && insuranceOrders.size() > 0) {
            insuranceOrdersDTOS = new ArrayList<>();
            for (InsuranceOrders insuranceOrder : insuranceOrders) {
                InsuranceOrdersDTO dto = new InsuranceOrdersDTO();
                BeanUtils.copyProperties(insuranceOrder, dto);
                insuranceOrdersDTOS.add(dto);
            }
        }
        return BaseResult.success("成功", insuranceOrdersDTOS);
    }

    /**
     * 提交订单接口
     * @param insuranceOrders
     * @return
     */
    @RequestMapping(value = "order_list",method = RequestMethod.POST)
    public BaseResult order(InsuranceOrders insuranceOrders){
       BaseResult baseResult= insuranceOrdersService.insertOrder(insuranceOrders);
       if (baseResult.getStatus()==500){
           return BaseResult.fail("订单提交失败");
       }
       else{
           InsuranceOrdersDTO dto = new InsuranceOrdersDTO();
           BeanUtils.copyProperties(insuranceOrders, dto);
           return BaseResult.success("订单提交成功",dto);
       }
    }
}
