package com.zz.zhongyuan.e.insurance.web.ui.interceptor;

import com.zz.zhongyuan.e.insurance.web.ui.dto.OrdinaryUsers;
import com.zz.zhongyuan.e.insurance.web.ui.constant.SystemConstants;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: LoginInterceptor
 * Description: <br/>
 * date: 2020/3/19 20:42
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        OrdinaryUsers ordinaryUsers= (OrdinaryUsers) httpServletRequest.getSession().getAttribute(SystemConstants.SESSION_USER_KEY);

        // 未登录状态
        if (ordinaryUsers == null) {
            return true;
        }

        // 已登录状态
        else {
            httpServletResponse.sendRedirect("/index");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
