package com.zz.zhongyuan.e.insurance.web.ui.controller;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.web.ui.api.OrdinaryUsersAPI;
import com.zz.zhongyuan.e.insurance.web.ui.dto.OrdinaryUsers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * ClassName: InfoController
 * Description: <br/>
 * date: 2020/4/20 21:26
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
public class PersonalInfoController {
    /**
     * 跳转个人信息页面
     *
     * @return
     */
    @RequestMapping(value ="personal/info", method = RequestMethod.GET)
    public String info(Model model,Long ouid){
        //请求个人信息
        requestPersonalInfo(model,ouid);
        return "personal_info";
    }

    /**
     * 请求个人信息
     * @param model
     */
    private void requestPersonalInfo(Model model, Long ouid){
        OrdinaryUsers ordinaryUsers = OrdinaryUsersAPI.personal_info(ouid);
        model.addAttribute("ordinaryUser", ordinaryUsers);
    }


    /**
     * 注册
     * @param ordinaryUsers
     * @return
     */
    @RequestMapping(value = "personal/update", method = RequestMethod.POST)
    public String updateInfo(OrdinaryUsers ordinaryUsers, RedirectAttributes redirectAttributes, HttpServletRequest request) throws Exception {
        String old_password=request.getParameter("old_password");
        String ouid=request.getParameter("ouid");
        OrdinaryUsers ordinaryUser = OrdinaryUsersAPI.personal_info(Long.parseLong(ouid));
        if (DigestUtils.md5DigestAsHex(old_password.getBytes()).equals(ordinaryUser.getPassword())){
            OrdinaryUsers users=OrdinaryUsersAPI.update_info(ordinaryUsers);
            // 注册成功
            if (users!=null) {
                redirectAttributes.addFlashAttribute("baseResult", BaseResult.success("修改个人信息成功"));
            }
            // 注册失败
            else {
                redirectAttributes.addFlashAttribute("baseResult",BaseResult.fail("邮箱或手机号已存在，请重新输入！"));
            }
        }else {
            redirectAttributes.addFlashAttribute("msg",BaseResult.fail("旧密码输入不正确，请重新输入！"));
        }
        redirectAttributes.addFlashAttribute("user",ordinaryUsers);
        return "redirect:/personal/info?ouid="+Long.parseLong(ouid);
    }
}
