package com.zz.zhongyuan.e.insurance.web.admin.users.web.controller;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.dto.PageInfo;
import com.zz.zhongyuan.e.insurance.domain.*;
import com.zz.zhongyuan.e.insurance.web.admin.users.service.InsuranceService;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * ClassName: InsuranceController
 * Description: <br/>
 * date: 2020/2/18 22:04
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
@RequestMapping(value = "insurance")
public class InsuranceController {
    @Autowired
    private InsuranceService insuranceService;

    @ModelAttribute
    public Insurance getInsurance(Long iid){
        //auid不为空从数据库获取
        Insurance insurance=null;
        if (iid!=null){
            insurance= insuranceService.getById(iid);
        }
        else {
            insurance=new Insurance();
        }
        return insurance;
    }

    /**
     * 跳转到列表页面
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "insurance_list";
    }

    /**
     * 跳转到添加内容页面
     * @return
     */
    @RequestMapping(value ="form",method = RequestMethod.GET)
    public String form(Model model,ArrayList<String> arrayList,ArrayList<Long> longArrayList){
        List<InsuranceCategory> insuranceCategories=insuranceService.selectAllPid();
        for (InsuranceCategory insuranceCategory : insuranceCategories){
            String insuranceCategoryName = insuranceCategory.getName();
            Long insuranceCategoryIcid = insuranceCategory.getIcid();
            longArrayList.add(insuranceCategoryIcid);
            arrayList.add(insuranceCategoryName);
        }
        model.addAttribute("insuranceCategoryIcid",longArrayList);
        model.addAttribute("insuranceCategoryName",arrayList);
        return "insurance_form";
    }

    /**
     * 保存信息到内容列表
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(Insurance insurance, Model model, RedirectAttributes redirectAttributes,HttpServletRequest request){
        String categoryName=request.getParameter("insuranceCategory.name");
        if (categoryName.equals("")){
            redirectAttributes.addFlashAttribute("categoryName",BaseResult.fail("父级目录不能为空"));
            return "redirect:/insurance/form";
        }
        BaseResult baseResult=insuranceService.save(insurance);
        //保存用户信息成功，跳转到用户列表页
        if (baseResult.getStatus()==200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/insurance/list";
        }
        //失败，跳转到表单页
        else {
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/insurance/form";
        }
    }


    /**
     * 修改保险状态
     * @param iid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "update" ,method = RequestMethod.POST)
    public BaseResult update(Long iid){
        BaseResult baseResult=null;
        if (iid != null){
            Insurance insurance = insuranceService.getById(iid);
            if (insurance.getState()==0){
                insurance.setState(1);
            }
            else {
                insurance.setState(0);
                insurance.setIsActivity(0);
                insurance.setBargainPrice(null);
            }
            insuranceService.update(insurance);
            baseResult=BaseResult.success("保险状态修改成功");
        }
        else {
            baseResult=BaseResult.fail(" 保险状态修改失败");
        }
        return baseResult;
    }


    /**
     * 修改活动状态
     * @param iid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "activity" ,method = RequestMethod.POST)
    public BaseResult activity(Long iid){
        BaseResult baseResult=null;
        if (iid != null){
            Insurance insurance = insuranceService.getById(iid);
            if (insurance.getIsActivity()==0 && insurance.getState()==1){
                insurance.setIsActivity(1);
            }
            else {
                insurance.setIsActivity(0);
                insurance.setBargainPrice(null);
            }
            insuranceService.update(insurance);
            baseResult=BaseResult.success("保险活动状态修改成功");
        }
        else {
            baseResult=BaseResult.fail("保险活动状态修改失败");
        }
        return baseResult;
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
            insuranceService.deleteMulti(idArray);
            baseResult=BaseResult.success("删除保险分类成功");
        }
        else {
            baseResult=BaseResult.fail("删除保险分类失败");
        }
        return baseResult;
    }

    /**
     * 删除
     * @param iid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete" ,method = RequestMethod.POST)
    public BaseResult delete(Long iid){
        BaseResult baseResult=null;
        if (iid != null){
            insuranceService.delete(iid);
            baseResult=BaseResult.success("保险删除成功");
        }
        else {
            baseResult=BaseResult.fail("保险删除失败");
        }
        return baseResult;
    }


    /**
     * 分页查询
     *
     * @param request
     * @param insurance
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<Insurance> page(HttpServletRequest request, Insurance insurance) {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        // 封装 Datatables 需要的结果
        PageInfo<Insurance> pageInfo = insuranceService.page(start, length, draw, insurance);

        return pageInfo;
    }

    /**
     * 显示详情
     *
     * @return
     */
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail() {
        return "insurance_detail";
    }
    /**
     * 显示保险内容
     *
     * @return
     */
    @RequestMapping(value = "content",method = RequestMethod.GET)
    public String content() {
        return "insurance_content";
    }
}
