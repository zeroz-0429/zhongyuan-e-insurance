package com.zz.zhongyuan.e.insurance.web.ui.controller;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.web.ui.api.InsuranceCategoryAPI;
import com.zz.zhongyuan.e.insurance.web.ui.api.InsuranceFavoriteAPI;
import com.zz.zhongyuan.e.insurance.web.ui.api.InsuranceOrderAPI;
import com.zz.zhongyuan.e.insurance.web.ui.dto.InsuranceCategory;
import com.zz.zhongyuan.e.insurance.web.ui.dto.InsuranceFavorite;
import com.zz.zhongyuan.e.insurance.web.ui.dto.InsuranceOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * ClassName: InsuranceFavoriteController
 * Description: <br/>
 * date: 2020/4/24 22:36
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
public class InsuranceFavoriteController {
    /**
     * 跳转保险收藏页面
     *
     * @return
     */
    @RequestMapping(value ="insurance/favorite", method = RequestMethod.GET)
    public String order(Model model, Long ouid) {
        //请求所有分类
        requestInsurancesList(model);
        //根据id请求用户收藏
        requestFavoriteList(model,ouid);
        return "insurance_favorite";
    }

    /**
     * 请求收藏列表
     * @param model
     */
    private void requestFavoriteList(Model model, Long ouid){
        if (ouid!=null){
            List<InsuranceFavorite> insuranceFavorites = InsuranceFavoriteAPI.favoriteList(ouid);
            model.addAttribute("favoriteList", insuranceFavorites);
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

    /**
     * 取消收藏
     *
     * @return
     */
    @RequestMapping(value ="/favorite/delete", method = RequestMethod.GET)
    public String order(Long iid, RedirectAttributes redirectAttributes,Long ouid) {
        BaseResult baseResult=InsuranceFavoriteAPI.deleteFavorite(iid,ouid);
        if (baseResult.getStatus()==200){
            redirectAttributes.addFlashAttribute("successDelete",BaseResult.success("取消收藏成功"));
        }
        else {
            redirectAttributes.addFlashAttribute("successDelete",BaseResult.fail("取消收藏失败"));
        }
        return "redirect:/insurance/favorite?ouid="+ouid;
    }

    /**
     * 加入收藏
     *
     * @return
     */
    @RequestMapping(value ="favorite/up", method = RequestMethod.POST)
    public String favoriteUp(InsuranceFavorite insuranceFavorite, RedirectAttributes redirectAttributes, HttpServletRequest request) throws Exception {
        String ouid=request.getParameter("ordinaryUsers.ouid");
        if (ouid.length()==0){
            return "insurance_favorite";
        }else {
            InsuranceFavorite favorite= InsuranceFavoriteAPI.favoriteUp(insuranceFavorite);
            if (favorite!=null){
                redirectAttributes.addFlashAttribute("baseResult", BaseResult.success("加入收藏成功"));
                return "redirect:/insurance/favorite?ouid="+insuranceFavorite.getOrdinaryUsers().getOuid();
            }
            else {
                redirectAttributes.addFlashAttribute("baseResult", BaseResult.fail("加入收藏失败"));
                return "redirect:/product/info?iid="+insuranceFavorite.getInsurance().getIid();
            }
        }
    }
}
