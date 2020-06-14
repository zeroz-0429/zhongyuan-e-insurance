package com.zz.zhongyuan.e.insurance.web.admin.web.interceptor;

import com.zz.zhongyuan.e.insurance.commons.constant.ConstantUtils;
import com.zz.zhongyuan.e.insurance.domain.SuperAdmin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: SuperAdminLoginInterceptor
 * Description: <br/>
 * date: 2020/2/1 22:00
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public class SuperAdminLoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        SuperAdmin superAdmin = (SuperAdmin) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);
        //如果未登录回到首页
        if (superAdmin==null){
            httpServletResponse.sendRedirect("/login");
        }
        //放行
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
