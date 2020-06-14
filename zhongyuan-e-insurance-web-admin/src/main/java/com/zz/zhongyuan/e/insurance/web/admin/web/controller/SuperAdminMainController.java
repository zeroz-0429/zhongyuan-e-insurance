package com.zz.zhongyuan.e.insurance.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClassName: SuperAdminMainController
 * Description: <br/>
 * date: 2020/2/1 16:46
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
public class SuperAdminMainController {
    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping(value = "main",method = RequestMethod.GET)
    public String main(){
        return "main";
    }
}
