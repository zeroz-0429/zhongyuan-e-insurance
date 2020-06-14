package com.zz.zhongyuan.e.insurance.web.ui.controller;

import com.zz.zhongyuan.e.insurance.web.ui.api.InsuranceAPI;
import com.zz.zhongyuan.e.insurance.web.ui.api.InsuranceCategoryAPI;
import com.zz.zhongyuan.e.insurance.web.ui.dto.Insurance;
import com.zz.zhongyuan.e.insurance.web.ui.dto.InsuranceCategory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * ClassName: InsurancePayController
 * Description: <br/>
 * date: 2020/4/26 19:55
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
public class InsurancePayController {

    /**
     * 跳转到保险支付页面
     * @return
     */
    @RequestMapping(value = "/insurance/pay",method = RequestMethod.GET)
    public String insurancePay(Model model,Long iid){
        //请求单个产品的所有信息
        requestSingleProduct(model,iid);
        //请求所有分类
        requestInsurancesList(model);
        return "insurance_pay";
    }

    /**
     * 请求所有分类内容
     * @param model
     */
    private void requestInsurancesList(Model model){
        List<InsuranceCategory> insuranceCategories= InsuranceCategoryAPI.category();
        model.addAttribute("category",insuranceCategories);
    }

    /**
     * 请求单个商品信息
     * @param model
     * @param iid
     */
    private void  requestSingleProduct(Model model , Long iid){
        List<Insurance> singleProduct= InsuranceAPI.product(iid);
        model.addAttribute("singleProduct",singleProduct);
    }
}
