package com.zz.zhongyuan.e.insurance.web.admin.users.web.controller;

import com.zz.zhongyuan.e.insurance.commons.constant.ConstantUtils;
import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.domain.AdminUsers;
import com.zz.zhongyuan.e.insurance.domain.SuperAdmin;
import com.zz.zhongyuan.e.insurance.web.admin.users.service.AdminUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: AdminUsersLoginController
 * Description: <br/>
 * date: 2020/2/8 22:30
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
public class AdminUsersLoginController {

    @Autowired
    private AdminUsersService adminUsersService;

    /**
     * 跳转到登录页
     * @return
     */
    @RequestMapping(value = {"login",""},method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    /**
     * 管理员登录
     * @param email
     * @param password
     * @param model
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String email, String password, Model model, HttpServletRequest httpServletRequest) {
        AdminUsers adminUsers = adminUsersService.login(email, password);

        //管理员登录失败,转发到登录页面
        if(adminUsers==null){
            model.addAttribute("message","邮箱或密码错误");
            model.addAttribute("email",email);
            return "login";
        }
        //登录成功，在会话中保存管理员信息，重定向到主界面
        else{
            if (adminUsers.getState()==0){
                model.addAttribute("baseResult", BaseResult.fail("您的账号还未激活，请稍后重试"));
                model.addAttribute("email",email);
                return "login";
            }
            else{
                httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_ADMIN_USERS,adminUsers);
                model.addAttribute("email",email);
                return "redirect:/main";
            }
        }
    }


    /**
     * 注销
     * @return
     */
    @RequestMapping(value = "logout" ,method = RequestMethod.GET)
    public String logout(){
        return "login";
    }
}
