package com.zz.zhongyuan.e.insurance.web.admin.web.controller;

import com.zz.zhongyuan.e.insurance.commons.constant.ConstantUtils;
import com.zz.zhongyuan.e.insurance.domain.SuperAdmin;
import com.zz.zhongyuan.e.insurance.web.admin.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: SuperAdminLoginController
 * Description: <br/>
 * date: 2020/1/31 23:56
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
public class SuperAdminLoginController {

    @Autowired
    private SuperAdminService superAdminService;

    /**
     * 跳转到登录页
     * @return
     */
    @RequestMapping(value = {"login",""},method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    /**
     * 超级管理员登录
     * @param phone
     * @param password
     * @param model
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String phone, String password, Model model,HttpServletRequest httpServletRequest) {
        SuperAdmin superAdmin = superAdminService.Login(phone, password);

        //超级管理员登录失败,转发到登录页面
        if(superAdmin==null){
            model.addAttribute("message","手机号或密码错误");
            return "login";
        }
        //登录成功，在会话中保存超级管理员信息，重定向到主界面
        else{
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER,superAdmin);
            return "redirect:/main";
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
