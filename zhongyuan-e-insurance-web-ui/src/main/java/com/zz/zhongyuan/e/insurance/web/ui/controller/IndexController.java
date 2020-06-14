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
 * ClassName: IndexController
 * Description: <br/>
 * date: 2020/3/19 22:43
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
public class IndexController {
    /**
     * 跳转首页
     *
     * @return
     */
    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public String index(Model model) {
        //请求幻灯片
        requestContentsPPT(model);
        //请求所有分类
        requestInsurancesList(model);
        //请求某个分类下的所有商品
        requestContentsList(model);
        //请求活动产品
        requestInsuranceActivity(model);
        return "index";
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
     * 请求某个分类下的所有保险
     * @param model
     */
    private void requestContentsList(Model model){
        List<InsuranceCategory> insuranceCategories= InsuranceCategoryAPI.category();
        for (int i=1; i<=insuranceCategories.size();i++){
            List<Insurance> insurances = InsuranceAPI.list((long) i);
            model.addAttribute("list"+i, insurances);
        }
    }

    /**
     * 请求活动产品
     *
     * @param model
     */
    private void requestInsuranceActivity(Model model) {
        List<Insurance> insurances = InsuranceAPI.isActivity();
        model.addAttribute("isActivity", insurances);
    }

    /**
     * 根据名称查询产品
     * @param name
     * @param model
     * @return
     */
    @RequestMapping(value = "search",method = RequestMethod.GET)
    public String search(String name,Model model){
        requestContentsPPT(model);
        requestInsurancesList(model);
        List<Insurance> insurances = InsuranceAPI.searchName(name);
        model.addAttribute("search", insurances);
        return "insurance_search";
    }

}
