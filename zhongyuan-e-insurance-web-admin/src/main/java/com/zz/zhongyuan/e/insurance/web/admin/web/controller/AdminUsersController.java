package com.zz.zhongyuan.e.insurance.web.admin.web.controller;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.dto.PageInfo;
import com.zz.zhongyuan.e.insurance.domain.AdminUsers;
import com.zz.zhongyuan.e.insurance.web.admin.service.AdminUsersService;
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
 * ClassName: AdminUsersController
 * Description: <br/>
 * date: 2020/2/1 22:40
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
@RequestMapping(value = "admin")
public class AdminUsersController {

    @Autowired
    private AdminUsersService adminUsersService;

    @ModelAttribute
    public AdminUsers getAdminUsers(Long auid){
        //auid不为空从数据库获取
        AdminUsers adminUsers=null;
        if (auid!=null){
            adminUsers= adminUsersService.getById(auid);
        }
        else {
            adminUsers=new AdminUsers();
        }
        return adminUsers;
    }

    /**
     * 跳转到管理员用户列表页面
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "admin_list";
    }

    /**
     * 跳转到添加用户页面
     * @return
     */
    @RequestMapping(value ="form",method = RequestMethod.GET)
    public String form(){
        return "admin_form";
    }

    /**
     * 保存用户信息到用户列表
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(AdminUsers adminUsers, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult=adminUsersService.save(adminUsers);
        //保存用户信息成功，跳转到用户列表页
        if (baseResult.getStatus()==200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/admin/list";
        }
        //失败，跳转到表单页
        else {
            model.addAttribute("baseResult",baseResult);
            return "admin_form";
        }
    }

    /**
     * 分页查询
     *
     * @param request
     * @param adminUsers
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<AdminUsers> page(HttpServletRequest request, AdminUsers adminUsers) {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        // 封装 Datatables 需要的结果
        PageInfo<AdminUsers> pageInfo = adminUsersService.page(start, length, draw, adminUsers);

        return pageInfo;
    }

    /**
     * 修改管理员状态
     * @param auid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "update" ,method = RequestMethod.POST)
    public BaseResult update(Long auid){
        BaseResult baseResult=null;
        if (auid != null){
            AdminUsers adminUsers = adminUsersService.getById(auid);
            if (adminUsers.getState()==0){
                adminUsers.setState(1);
            }
            else {
                adminUsers.setState(0);
            }
            adminUsersService.update(adminUsers);
            baseResult=BaseResult.success("管理员状态修改成功");
        }
        else {
            baseResult=BaseResult.fail("管理员状态修改失败");
        }
        return baseResult;
    }

    /**
     * 批量删除
     * @param auids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deleteMul" ,method = RequestMethod.POST)
    public BaseResult delete(String auids){
        BaseResult baseResult=null;
        if (StringUtils.isNotBlank(auids)){
            String[] idArray=auids.split(",");
            adminUsersService.deleteMulti(idArray);
            baseResult=BaseResult.success("删除管理员用户成功");
        }
        else {
            baseResult=BaseResult.fail("删除管理员用户失败");
        }
        return baseResult;
    }


    /**
     * 单个删除
     * @param auid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete" ,method = RequestMethod.POST)
    public BaseResult delete(Long  auid){
        BaseResult baseResult=null;
        if (auid != null){
            adminUsersService.delete(auid);
            baseResult=BaseResult.success("管理员删除成功");
        }
        else {
            baseResult=BaseResult.fail("管理员删除失败");
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
        return "admin_detail";
    }
}
