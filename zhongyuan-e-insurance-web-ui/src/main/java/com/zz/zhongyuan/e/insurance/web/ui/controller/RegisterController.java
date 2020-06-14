package com.zz.zhongyuan.e.insurance.web.ui.controller;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.utils.RegexpUtils;
import com.zz.zhongyuan.e.insurance.web.ui.api.OrdinaryUsersAPI;
import com.zz.zhongyuan.e.insurance.web.ui.dto.OrdinaryUsers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: RegisterController
 * Description: <br/>
 * date: 2020/3/19 22:43
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
public class RegisterController {
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
     * @param ordinaryUsers
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(OrdinaryUsers ordinaryUsers, Model model, HttpServletRequest request) throws Exception {
        boolean isRemember = request.getParameter("isRemember") == null ? false : true;
        if (!isRemember){
            model.addAttribute("message",BaseResult.fail("请勾选同意后再登录"));
            model.addAttribute("user",ordinaryUsers);
        }else {
            if (ordinaryUsers.getUsername().length()<=2 || ordinaryUsers.getUsername().length()>=20){
                model.addAttribute("resultName",BaseResult.fail("用户名必须在2到20个字符之间"));
                model.addAttribute("user",ordinaryUsers);
                return "register";
            }else if (!RegexpUtils.checkPhone(ordinaryUsers.getPhone())){
                model.addAttribute("resultPhone",BaseResult.fail("手机号格式不正确"));
                model.addAttribute("user",ordinaryUsers);
                return "register";
            }else if (!RegexpUtils.checkEmail(ordinaryUsers.getEmail())){
                model.addAttribute("resultEmail",BaseResult.fail("邮箱格式不正确"));
                model.addAttribute("user",ordinaryUsers);
                return "register";
            }else{
                String password=request.getParameter("password");
                String repassword=request.getParameter("repassword");
                if (password.length()<6 || password.length()>=20){
                    model.addAttribute("resultPassword",BaseResult.fail("密码必须在6到20位之间"));
                    model.addAttribute("user",ordinaryUsers);
                    return "register";
                }
                if (password.equals(repassword)){
                    OrdinaryUsers user= OrdinaryUsersAPI.register(ordinaryUsers);
                    // 注册成功
                    if (user!=null) {
                        model.addAttribute("baseResult", BaseResult.success("恭喜你，注册成功！可以点击右上角的登录按钮前去登录"));
                    }
                    // 注册失败
                    else {
                        model.addAttribute("user",ordinaryUsers);
                        model.addAttribute("baseResult",BaseResult.fail("用户名或邮箱或手机号已存在，请重新输入！"));
                    }
                }
                else {
                    model.addAttribute("user",ordinaryUsers);
                    model.addAttribute("msg",BaseResult.fail("两次输入的密码不同，请重新输入！"));
                }
            }
        }
        return "register";
    }
}
