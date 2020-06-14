package com.zz.zhongyuan.e.insurance.web.admin.users.web.controller;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.dto.PageInfo;
import com.zz.zhongyuan.e.insurance.domain.AdminUsers;
import com.zz.zhongyuan.e.insurance.domain.InsuranceOrders;
import com.zz.zhongyuan.e.insurance.domain.OrdinaryUsers;
import com.zz.zhongyuan.e.insurance.web.admin.users.service.InsuranceOrdersService;
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

/**
 * ClassName: InsuranceOrdersController
 * Description: <br/>
 * date: 2020/2/18 22:05
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
@RequestMapping(value = "insurance/orders")
public class InsuranceOrdersController {
    @Autowired
    private InsuranceOrdersService insuranceOrdersService;

    @ModelAttribute
    public InsuranceOrders getInsuranceOrders(Long ioid){
        //ioid不为空从数据库获取
        InsuranceOrders insuranceOrders=null;
        if (ioid!=null){
            insuranceOrders= insuranceOrdersService.getById(ioid);
        }
        else {
            insuranceOrders=new InsuranceOrders();
        }
        return insuranceOrders;
    }

    /**
     * 跳转到管理员用户列表页面
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "insurance_orders_list";
    }


    /**
     * 跳转到管理员用户列表页面
     * @return
     */
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(){
        return "insurance_orders_form";
    }

    /**
     * 保存用户信息到用户列表
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(InsuranceOrders insuranceOrders, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult=insuranceOrdersService.save(insuranceOrders);
        //保存用户信息成功，跳转到用户列表页
        if (baseResult.getStatus()==200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/insurance/orders/list";
        }
        //失败，跳转到表单页
        else {
            model.addAttribute("baseResult",baseResult);
            return "insurance_orders_form";
        }
    }

    /**
     * 分页查询
     *
     * @param request
     * @param insuranceOrders
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<InsuranceOrders> page(HttpServletRequest request, InsuranceOrders insuranceOrders) {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        // 封装 Datatables 需要的结果
        PageInfo<InsuranceOrders> pageInfo = insuranceOrdersService.page(start, length, draw, insuranceOrders);

        return pageInfo;
    }

    /**
     * 修改保单状态
     * @param ioid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "update" ,method = RequestMethod.POST)
    public BaseResult update(Long ioid){
        BaseResult baseResult=null;
        if (ioid != null){
            InsuranceOrders insuranceOrders = insuranceOrdersService.getById(ioid);
            if (insuranceOrders.getState()==0){
                insuranceOrders.setState(1);
            }
            else {
                insuranceOrders.setState(0);
            }
            insuranceOrdersService.update(insuranceOrders);
            baseResult=BaseResult.success("用户保单状态修改成功");
        }
        else {
            baseResult=BaseResult.fail("用户保单状态修改失败");
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
            insuranceOrdersService.deleteMulti(idArray);
            baseResult=BaseResult.success("删除用户保单成功");
        }
        else {
            baseResult=BaseResult.fail("删除用户保单失败");
        }
        return baseResult;
    }

    /**
     * 删除
     * @param ioid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete" ,method = RequestMethod.POST)
    public BaseResult delete(Long ioid){
        BaseResult baseResult=null;
        if (ioid != null){
            insuranceOrdersService.delete(ioid);
            baseResult=BaseResult.success("用户保单删除成功");
        }
        else {
            baseResult=BaseResult.fail("用户保单删除失败");
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
        return "insurance_orders_detail";
    }
}
