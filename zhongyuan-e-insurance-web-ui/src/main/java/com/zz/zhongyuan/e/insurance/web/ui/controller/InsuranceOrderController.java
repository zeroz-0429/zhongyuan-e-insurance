package com.zz.zhongyuan.e.insurance.web.ui.controller;

import com.zz.zhongyuan.e.insurance.web.ui.api.InsuranceCategoryAPI;
import com.zz.zhongyuan.e.insurance.web.ui.api.InsuranceOrderAPI;
import com.zz.zhongyuan.e.insurance.web.ui.dto.InsuranceCategory;
import com.zz.zhongyuan.e.insurance.web.ui.dto.InsuranceOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * ClassName: InsuranceOrderController
 * Description: <br/>
 * date: 2020/4/20 23:54
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
public class InsuranceOrderController {
    /**
     * 跳转保险订单页面
     *
     * @return
     */
    @RequestMapping(value ="insurance/order", method = RequestMethod.GET)
    public String order(Model model,Long ouid) {
        //请求所有分类
        requestInsurancesList(model);
        //根据id请求用户保单
        requestOrderList(model,ouid);
        return "insurance_order";
    }

    /**
     * 根据id请求用户保单
     * @param model
     */
    private void requestOrderList(Model model, Long ouid){
        if (ouid!=null){
            List<InsuranceOrder> insuranceOrders = InsuranceOrderAPI.orderList(ouid);
            model.addAttribute("order", insuranceOrders);
        }
    }

    /**
     * 请求所有分类内容
     * @param model
     */
    private void requestInsurancesList(Model model){
        List<InsuranceCategory> insuranceCategories= InsuranceCategoryAPI.category();
        model.addAttribute("category",insuranceCategories);
    }
}
