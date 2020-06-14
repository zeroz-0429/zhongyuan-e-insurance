package com.zz.zhongyuan.e.insurance.web.admin.users.web.controller;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.domain.AdminUsers;
import com.zz.zhongyuan.e.insurance.web.admin.users.service.AdminUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * ClassName: AdminUsersInfoController
 * Description: <br/>
 * date: 2020/4/4 23:09
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
@RequestMapping(value = "admin/users")
public class AdminUsersInfoController {

    @Autowired
    private AdminUsersService adminUsersService;

    @ModelAttribute
    public AdminUsers getOrdinaryUsers(Long auid){
        //ouid不为空从数据库获取
        AdminUsers adminUsers=null;
        if (auid!=null){
            adminUsers= adminUsersService.getById(auid);
        }
        else {
            adminUsers=new AdminUsers();
        }
        return adminUsers;
    }

    /**
     * 跳转到个人信息页面
     * @return
     */
    @RequestMapping(value = "info",method = RequestMethod.GET)
    public String info(){
        return "admin_users_info";
    }


    /**
     * 保存用户信息到用户列表
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(AdminUsers adminUsers, Model model, HttpServletRequest request){
        AdminUsers adminUser=adminUsersService.getById(adminUsers.getAuid());
        String password=DigestUtils.md5DigestAsHex(request.getParameter("password").getBytes());
        //密码验证成功
        if (password.equals(adminUser.getPassword())){
            BaseResult baseResult=adminUsersService.insert(adminUsers);
            //手机号和邮箱都正确
            if (baseResult.getStatus()==200){
                model.addAttribute("baseResult",baseResult);
                return "admin_users_info";
            }
            //手机号或邮箱有误
            else {
                model.addAttribute("baseResult",baseResult);
                return "admin_users_info";
            }
        }
        //密码验证失败
        else {
            model.addAttribute("baseResult",BaseResult.fail("密码验证失败"));
            return "admin_users_info";
        }
    }
    /**
     * 跳转到修改密码页面
     * @return
     */
    @RequestMapping(value = "pwd_update",method = RequestMethod.GET)
    public String pwd_update(){
        return "admin_users_pwd_update";
    }

    /**
     * 保存用户信息到用户列表
     * @return
     */
    @RequestMapping(value = "edit",method = RequestMethod.POST)
    public String edit(AdminUsers adminUsers, Model model, HttpServletRequest request){
        AdminUsers adminUser=adminUsersService.getById(adminUsers.getAuid());
        String password=DigestUtils.md5DigestAsHex(request.getParameter("password").getBytes());
        String newPassword=request.getParameter("newPassword");
        String newPwd= DigestUtils.md5DigestAsHex(newPassword.getBytes());
        String newPassword2=request.getParameter("newPassword2");
        //密码验证成功
        if (password.equals(adminUser.getPassword())){
            if ( newPassword.length()>=6 && newPassword.length()<=20){
                if (!newPwd.equals(adminUser.getPassword())){
                    if (newPassword.equals(newPassword2)){
                        adminUsers.setPassword(DigestUtils.md5DigestAsHex(newPassword.getBytes()));
                        adminUsers.setUpdated(new Date());
                        adminUsersService.update(adminUsers);
                        model.addAttribute("baseResult",BaseResult.success("密码修改成功"));
                    }
                    else {
                        model.addAttribute("baseResult",BaseResult.fail("两次密码输入不同，请重新输入"));
                    }
                }
                else {
                    model.addAttribute("baseResult",BaseResult.fail("新密码和旧密码不能相同，请重新输入"));
                }
            }
            else {
                model.addAttribute("baseResult",BaseResult.fail("新密码必须在6到20位之间"));
            }
        }
        //密码验证失败
        else {
            model.addAttribute("baseResult",BaseResult.fail("旧密码有误"));
        }
        return "admin_users_pwd_update";
    }
}
