package com.zz.zhongyuan.e.insurance.web.ui.controller;

import com.zz.zhongyuan.e.insurance.web.ui.api.ContentAPI;
import com.zz.zhongyuan.e.insurance.web.ui.api.InsuranceAPI;
import com.zz.zhongyuan.e.insurance.web.ui.api.InsuranceCategoryAPI;
import com.zz.zhongyuan.e.insurance.web.ui.api.OrdinaryUsersAPI;
import com.zz.zhongyuan.e.insurance.web.ui.dto.Content;
import com.zz.zhongyuan.e.insurance.web.ui.dto.Insurance;
import com.zz.zhongyuan.e.insurance.web.ui.dto.InsuranceCategory;
import com.zz.zhongyuan.e.insurance.web.ui.dto.OrdinaryUsers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

/**
 * ClassName: InsuranceController
 * Description: <br/>
 * date: 2020/4/19 10:16
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
public class InsuranceListController {
    /**
     * 跳转商品分类页面
     * @return
     */
    @RequestMapping(value = "insurance_list",method = RequestMethod.GET)
    public String insuranceList(Model model, Long categoryId) {
        // 请求幻灯片
        requestContentsPPT(model);
        //请求所有分类内容
        requestInsurancesList(model);
        //请求某个分类下的所有商品
        requestContentsList(model,categoryId);
        return "insurance_list";
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
     * 请求幻灯片
     *
     * @param model
     */
    private void requestContentsPPT(Model model) {
        List<Content> contents = ContentAPI.ppt();
        model.addAttribute("ppt", contents);
    }

    /**
     * 请求某个分类下的所有保险
     * @param model
     */
    private void requestContentsList(Model model,Long categoryId){
        List<Insurance> insurances = InsuranceAPI.list(categoryId);
        model.addAttribute("list", insurances);
    }
}
