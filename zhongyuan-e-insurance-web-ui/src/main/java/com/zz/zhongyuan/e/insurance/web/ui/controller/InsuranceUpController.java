package com.zz.zhongyuan.e.insurance.web.ui.controller;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.utils.RegexpUtils;
import com.zz.zhongyuan.e.insurance.web.ui.api.InsuranceAPI;
import com.zz.zhongyuan.e.insurance.web.ui.api.InsuranceCategoryAPI;
import com.zz.zhongyuan.e.insurance.web.ui.api.InsuranceOrderAPI;
import com.zz.zhongyuan.e.insurance.web.ui.dto.Insurance;
import com.zz.zhongyuan.e.insurance.web.ui.dto.InsuranceCategory;
import com.zz.zhongyuan.e.insurance.web.ui.dto.InsuranceOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * ClassName: InsuranceUpController
 * Description: <br/>
 * date: 2020/4/20 23:55
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
public class InsuranceUpController {
    /**
     * 跳转保险提交页面
     *
     * @return
     */
    @RequestMapping(value ="insurance/up", method = RequestMethod.GET)
    public String up(Model model,Long iid) {
        //请求所有分类内容
        requestInsurancesList(model);
        //请求单个商品信息
        requestSingleProduct(model,iid);
        return "insurance_up";
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

    /**
     * 跳转保险提交页面
     *
     * @return
     */
    @RequestMapping(value ="insurance/up", method = RequestMethod.POST)
    public String up(InsuranceOrder insuranceOrder, Model model, RedirectAttributes redirectAttributes) throws Exception {
        if (insuranceOrder.getName().length()==0){
            redirectAttributes.addFlashAttribute("name",BaseResult.fail("被保人姓名不能为空！"));
            redirectAttributes.addFlashAttribute("order",insuranceOrder);
            return "redirect:/insurance/up?iid="+insuranceOrder.getInsurance().getIid();
           }
//        else if (!RegexpUtils.checkCard(insuranceOrder.getIdentityCard())){
//            redirectAttributes.addFlashAttribute("card",BaseResult.fail("被保人身份证格式不正确！"));
//            redirectAttributes.addFlashAttribute("order",insuranceOrder);
//            return "redirect:/insurance/up?iid="+insuranceOrder.getInsurance().getIid();
//        }
        else if (!RegexpUtils.checkPhone(insuranceOrder.getPhone())){
            redirectAttributes.addFlashAttribute("phone",BaseResult.fail("被保人手机号格式不正确！"));
            redirectAttributes.addFlashAttribute("order",insuranceOrder);
            return "redirect:/insurance/up?iid="+insuranceOrder.getInsurance().getIid();
        }else{
            InsuranceOrder order= InsuranceOrderAPI.orderUp(insuranceOrder);
            if (order!=null){
                redirectAttributes.addFlashAttribute("baseResult", BaseResult.success("订单提交成功"));
                return "redirect:/insurance/pay?iid="+insuranceOrder.getInsurance().getIid();
            }
            else {
                model.addAttribute("baseResult", BaseResult.fail("订单提交失败"));
            }
            model.addAttribute("order",insuranceOrder);
            return "insurance_up";
        }

    }
}
