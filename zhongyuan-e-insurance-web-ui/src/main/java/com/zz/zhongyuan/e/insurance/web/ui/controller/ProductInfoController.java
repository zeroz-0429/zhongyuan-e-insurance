package com.zz.zhongyuan.e.insurance.web.ui.controller;

import com.zz.zhongyuan.e.insurance.web.ui.api.ContentAPI;
import com.zz.zhongyuan.e.insurance.web.ui.api.InsuranceAPI;
import com.zz.zhongyuan.e.insurance.web.ui.api.InsuranceCategoryAPI;
import com.zz.zhongyuan.e.insurance.web.ui.dto.Content;
import com.zz.zhongyuan.e.insurance.web.ui.dto.Insurance;
import com.zz.zhongyuan.e.insurance.web.ui.dto.InsuranceCategory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * ClassName: ProductInfoController
 * Description: <br/>
 * date: 2020/4/20 23:10
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
public class ProductInfoController {
    /**
     * 跳转产品信息页面
     *
     * @return
     */
    @RequestMapping(value ="product/info", method = RequestMethod.GET)
    public String info(Model model,Long iid) {
        //请求你幻灯片
        requestContentsPPT(model);
        //请求单个产品的所有信息
        requestSingleProduct(model,iid);
        //请求所有分类
        requestInsurancesList(model);
        return "product_info";
    }


    /**
     * 请求幻灯片
     *
     * @param model
     */
    private void requestContentsPPT(Model model) {
        List<Content> contents = ContentAPI.ppt();
        model.addAttribute("ppt", contents);
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
