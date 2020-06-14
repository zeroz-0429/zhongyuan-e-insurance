package com.zz.zhongyuan.e.insurance.web.admin.users.web.controller;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.dto.PageInfo;
import com.zz.zhongyuan.e.insurance.domain.AdminUsers;
import com.zz.zhongyuan.e.insurance.domain.OrdinaryUsers;
import com.zz.zhongyuan.e.insurance.web.admin.users.service.OrdinaryUsersService;
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
 * ClassName: OrdinaryUsersController
 * Description: <br/>
 * date: 2020/2/18 22:06
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
@RequestMapping(value = "ordinary/users")
public class OrdinaryUsersController {
    @Autowired
    private OrdinaryUsersService ordinaryUsersService;

    @ModelAttribute
    public OrdinaryUsers getOrdinaryUsers(Long ouid){
        //ouid不为空从数据库获取
        OrdinaryUsers ordinaryUsers=null;
        if (ouid!=null){
            ordinaryUsers= ordinaryUsersService.getById(ouid);
        }
        else {
            ordinaryUsers=new OrdinaryUsers();
        }
        return ordinaryUsers;
    }

    /**
     * 跳转到管理员用户列表页面
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "ordinary_users_list";
    }

    /**
     * 跳转到添加用户页面
     * @return
     */
    @RequestMapping(value ="form",method = RequestMethod.GET)
    public String form(){
        return "ordinary_users_form";
    }

    /**
     * 保存用户信息到用户列表
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(OrdinaryUsers ordinaryUsers, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult=ordinaryUsersService.save(ordinaryUsers);
        //保存用户信息成功，跳转到用户列表页
        if (baseResult.getStatus()==200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/ordinary/users/list";
        }
        //失败，跳转到表单页
        else {
            model.addAttribute("baseResult",baseResult);
            return "ordinary_users_form";
        }
    }

    /**
     * 分页查询
     *
     * @param request
     * @param ordinaryUsers
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<OrdinaryUsers> page(HttpServletRequest request, OrdinaryUsers ordinaryUsers) {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        // 封装 Datatables 需要的结果
        PageInfo<OrdinaryUsers> pageInfo = ordinaryUsersService.page(start, length, draw, ordinaryUsers);

        return pageInfo;
    }


    /**
     * 修改普通用户状态
     * @param ouid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "update" ,method = RequestMethod.POST)
    public BaseResult update(Long ouid){
        BaseResult baseResult=null;
        if (ouid != null){
            OrdinaryUsers ordinaryUsers = ordinaryUsersService.getById(ouid);
            if (ordinaryUsers.getState()==0){
                ordinaryUsers.setState(1);
            }
            else {
                ordinaryUsers.setState(0);
            }
            ordinaryUsersService.update(ordinaryUsers);
            baseResult=BaseResult.success("用户状态修改成功");
        }
        else {
            baseResult=BaseResult.fail("用户状态修改失败");
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
            ordinaryUsersService.deleteMulti(idArray);
            baseResult=BaseResult.success("删除普通用户成功");
        }
        else {
            baseResult=BaseResult.fail("删除普通用户失败");
        }
        return baseResult;
    }

    /**
     * 删除
     * @param ouid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete" ,method = RequestMethod.POST)
    public BaseResult delete(Long ouid){
        BaseResult baseResult=null;
        if (ouid != null){
            ordinaryUsersService.delete(ouid);
            baseResult=BaseResult.success("普通用户删除成功");
        }
        else {
            baseResult=BaseResult.fail("普通用户删除失败");
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
        return "ordinary_users_detail";
    }
}
