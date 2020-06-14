package com.zz.zhongyuan.e.insurance.web.ui.controller;

import com.google.code.kaptcha.Constants;
import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.utils.CookieUtils;
import com.zz.zhongyuan.e.insurance.web.ui.api.OrdinaryUsersAPI;
import com.zz.zhongyuan.e.insurance.web.ui.constant.SystemConstants;
import com.zz.zhongyuan.e.insurance.web.ui.dto.OrdinaryUsers;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: LoginController
 * Description: <br/>
 * date: 2020/3/19 22:43
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
public class LoginController {
    private static final String COOK_NAME="Info";

    /**
     * 跳转登录页
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(HttpServletRequest httpServletRequest) {
        String userInfo= CookieUtils.getCookieValue(httpServletRequest,COOK_NAME);
        if (!StringUtils.isBlank(userInfo)){
            String[] userInfoArray=userInfo.split(":");
            String username=userInfoArray[0];
            String password=userInfoArray[1];
            httpServletRequest.setAttribute("username",username);
            httpServletRequest.setAttribute("password",password);
            httpServletRequest.setAttribute("isRemember",true);
        }
        return "login";
    }

    /**
     * 登录
     * @param ordinaryUsers
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(OrdinaryUsers ordinaryUsers, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        boolean isRemember = request.getParameter("isRemember") == null ? false : true;
        //用户选择不记住
        if (!isRemember){
            CookieUtils.deleteCookie(request,response,COOK_NAME);
        }
        // 验证码验证失败
        if (!checkVerification(ordinaryUsers, request)) {
            model.addAttribute("baseResult", BaseResult.fail("验证码输入错误，请重新输入"));
            return "login";
        }

        OrdinaryUsers user = OrdinaryUsersAPI.login(ordinaryUsers);
        // 登录失败
        if (user == null) {
            model.addAttribute("baseResult", BaseResult.fail("用户名或密码错误，请重新输入！"));
            model.addAttribute("ordinaryUsers",ordinaryUsers);
            return "login";
        }

        // 登录成功
        else {
            if (isRemember){
                CookieUtils.setCookie(request,response,COOK_NAME,String.format("%s:%s",ordinaryUsers.getUsername(),ordinaryUsers.getPassword()),7*24*60*60);
            }
            // 将会员信息放入 Session
            request.getSession().setAttribute(SystemConstants.SESSION_USER_KEY, user);
            return "redirect:/index";
        }
    }

    /**
     * 注销
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/index";
    }

    /**
     * 检查验证码
     * @param ordinaryUsers
     * @param request
     * @return
     */
    private boolean checkVerification(OrdinaryUsers ordinaryUsers, HttpServletRequest request) {
        String verification = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (StringUtils.equals(verification, ordinaryUsers.getVerification())) {
            return true;
        }

        return false;
    }
}
