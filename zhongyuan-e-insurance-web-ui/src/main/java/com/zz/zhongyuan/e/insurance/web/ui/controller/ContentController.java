package com.zz.zhongyuan.e.insurance.web.ui.controller;

import com.zz.zhongyuan.e.insurance.web.ui.api.ContentAPI;
import com.zz.zhongyuan.e.insurance.web.ui.api.InsuranceCategoryAPI;
import com.zz.zhongyuan.e.insurance.web.ui.dto.Content;
import com.zz.zhongyuan.e.insurance.web.ui.dto.InsuranceCategory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * ClassName: ContentController
 * Description: <br/>
 * date: 2020/4/26 15:19
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
public class ContentController {
    /**
     * 跳转保险介绍页面
     *
     * @return
     */
    @RequestMapping(value = "/insurance/introduce", method = RequestMethod.GET)
    public String insuranceIntroduce(Model model) {
        //请求所有分类
        requestInsurancesList(model);
        //请求投保流程
        requestInsuranceIntroduce(model);
        return "insurance_introduce";
    }

    /**
     * 跳转公司介绍页面
     *
     * @return
     */
    @RequestMapping(value = "/company/info", method = RequestMethod.GET)
    public String companyInfo(Model model) {
        //请求所有分类
        requestInsurancesList(model);
        //请求公司信息
        requestCompanyInfo(model);
        //请求公司发展
        requestCompanyDev(model);
        return "company_info";
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
     * 请求公司信息
     * @param model
     */
    private void requestCompanyInfo(Model model){
        List<Content> contents= ContentAPI.companyInfo();
        model.addAttribute("companyInfo",contents);
    }

    /**
     * 请求公司发展
     * @param model
     */
    private void requestCompanyDev(Model model){
        List<Content> contents= ContentAPI.companyDev();
        model.addAttribute("companyDev",contents);
}

    /**
     * 请求投保流程
     * @param model
     */
    private void requestInsuranceIntroduce(Model model){
        List<Content> contents= ContentAPI.introduce();
        model.addAttribute("insuranceIntroduce",contents);
    }


}
