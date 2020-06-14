package com.zz.zhongyuan.e.insurance.web.admin.users.web.controller;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.dto.PageInfo;
import com.zz.zhongyuan.e.insurance.domain.AdminUsers;
import com.zz.zhongyuan.e.insurance.domain.ContentCategory;
import com.zz.zhongyuan.e.insurance.domain.InsuranceCategory;
import com.zz.zhongyuan.e.insurance.domain.OrdinaryUsers;
import com.zz.zhongyuan.e.insurance.web.admin.users.service.InsuranceCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * ClassName: InsuranceCategoryController
 * Description: <br/>
 * date: 2020/2/18 22:04
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
@RequestMapping(value = "insurance/category")
public class InsuranceCategoryController {

    @Autowired
    private InsuranceCategoryService insuranceCategoryService;

    @ModelAttribute
    public InsuranceCategory getInsuranceCategory(Long icid){
        //auid不为空从数据库获取
        InsuranceCategory insuranceCategory=null;
        if (icid!=null){
            insuranceCategory= insuranceCategoryService.getById(icid);
        }
        else {
            insuranceCategory=new InsuranceCategory();
        }
        return insuranceCategory;
    }

    /**
     * 跳转到管理员用户列表页面
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "insurance_category_list";
    }

    /**
     * 跳转到添加用户页面
     * @return
     */
    @RequestMapping(value ="form",method = RequestMethod.GET)
    public String form(){
        return "insurance_category_form";
    }

    /**
     * 保存用户信息到用户列表
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(InsuranceCategory insuranceCategory, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult=insuranceCategoryService.save(insuranceCategory);
        //保存用户信息成功，跳转到用户列表页
        if (baseResult.getStatus()==200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/insurance/category/list";
        }
        //失败，跳转到表单页
        else {
            model.addAttribute("baseResult",baseResult);
            return "insurance_category_form";
        }
    }


    /**
     * 分页查询
     *
     * @param request
     * @param insuranceCategory
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<InsuranceCategory> page(HttpServletRequest request, InsuranceCategory insuranceCategory) {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        // 封装 Datatables 需要的结果
        PageInfo<InsuranceCategory> pageInfo = insuranceCategoryService.page(start, length, draw, insuranceCategory);

        return pageInfo;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deleteMul" ,method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult=null;
        if (StringUtils.isNotBlank(ids)){
            String[] idArray=ids.split(",");
            insuranceCategoryService.deleteMulti(idArray);
            baseResult=BaseResult.success("删除保险分类成功");
        }
        else {
            baseResult=BaseResult.fail("删除保险分类失败");
        }
        return baseResult;
    }

    /**
     * 删除
     * @param icid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete" ,method = RequestMethod.POST)
    public BaseResult delete(Long icid){
        BaseResult baseResult=null;
        if (icid != null){
            insuranceCategoryService.delete(icid);
            baseResult=BaseResult.success("保险分类删除成功");
        }
        else {
            baseResult=BaseResult.fail("保险分类删除失败");
        }
        return baseResult;
    }

    /**
     * 显示管理员用户详情
     *
     * @return
     */
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail() {
        return "insurance_category_detail";
    }

}
