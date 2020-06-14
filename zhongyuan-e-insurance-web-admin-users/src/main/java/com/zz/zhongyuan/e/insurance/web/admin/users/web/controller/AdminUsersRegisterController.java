package com.zz.zhongyuan.e.insurance.web.admin.users.web.controller;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.domain.AdminUsers;
import com.zz.zhongyuan.e.insurance.web.admin.users.service.AdminUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: AdminUsersRegisterController
 * Description: <br/>
 * date: 2020/2/12 21:41
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
public class AdminUsersRegisterController {

    @Autowired
    private AdminUsersService adminUsersService;
    /**
     * 跳转注册页
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }


    /**
     * 注册
     * @param adminUsers
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(AdminUsers adminUsers,Model model, HttpServletRequest request){
        boolean isRemember = request.getParameter("isRemember") == null ? false : true;
        String password=request.getParameter("password");
        String re_password=request.getParameter("re_password");
        if (password.equals(re_password)){
            if (!isRemember){
                model.addAttribute("message1",BaseResult.fail("请勾选同意后再登录"));
            }
            else{
                AdminUsers adminUser=adminUsersService.register(adminUsers);
                if (adminUser==null){
                    model.addAttribute("baseResult", BaseResult.fail("手机号或邮箱已存在，请重新输入！"));
                }
                else {
                    adminUsers.setPhone("");
                    adminUsers.setEmail("");
                    model.addAttribute("baseResult",BaseResult.success("恭喜你，注册成功！账号激活后会通过注册邮箱通知您"));
                }
            }
        }
        else {
            model.addAttribute("message2",BaseResult.fail("两次输入的密码不同，请重新输入！"));
        }
        model.addAttribute("adminUsers",adminUsers);
        return "register";
    }
}
