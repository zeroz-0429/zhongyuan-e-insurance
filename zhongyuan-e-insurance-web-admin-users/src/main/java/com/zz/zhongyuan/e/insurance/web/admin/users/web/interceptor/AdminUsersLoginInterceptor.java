package com.zz.zhongyuan.e.insurance.web.admin.users.web.interceptor;

import com.zz.zhongyuan.e.insurance.commons.constant.ConstantUtils;
import com.zz.zhongyuan.e.insurance.domain.AdminUsers;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: AdminUsersLoginInterceptor
 * Description: <br/>
 * date: 2020/2/8 19:38
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public class AdminUsersLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        AdminUsers adminUsers = (AdminUsers) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_ADMIN_USERS);
        //如果未登录回到首页
        if (adminUsers==null){
            httpServletResponse.sendRedirect("/login");
        }
        //放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
