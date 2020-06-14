package com.zz.zhongyuan.e.insurance.web.api.web.controller;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.domain.Insurance;
import com.zz.zhongyuan.e.insurance.domain.OrdinaryUsers;
import com.zz.zhongyuan.e.insurance.web.api.service.OrdinaryUsersService;
import com.zz.zhongyuan.e.insurance.web.api.web.dto.InsuranceDTO;
import com.zz.zhongyuan.e.insurance.web.api.web.dto.OrdinaryUsersDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: OrdinaryUsersController
 * Description: <br/>
 * date: 2020/3/19 21:32
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@RestController
@RequestMapping(value = "/api/ordinary_users")
public class OrdinaryUsersController {
    @Autowired
    private OrdinaryUsersService ordinaryUsersService;

    /**
     * 登录
     *
     * @param ordinaryUsers
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public BaseResult login(OrdinaryUsers ordinaryUsers) {
        OrdinaryUsers user = ordinaryUsersService.login(ordinaryUsers);
        if (user == null) {
            return BaseResult.fail("账号或密码错误");
        } else {
            OrdinaryUsersDTO dto = new OrdinaryUsersDTO();
            BeanUtils.copyProperties(user, dto);
            return BaseResult.success("成功", dto);
        }
    }

    /**
     * 注册
     * @param ordinaryUsers
     * @return
     */
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public BaseResult register(OrdinaryUsers ordinaryUsers){
        BaseResult baseResult=ordinaryUsersService.register(ordinaryUsers);
        //注册失败
        if (baseResult.getStatus()==500){
            return BaseResult.fail("用户名或邮箱或手机号已存在");
        }
        //注册成功
        else {
            OrdinaryUsersDTO dto = new OrdinaryUsersDTO();
            BeanUtils.copyProperties(ordinaryUsers, dto);
            return BaseResult.success("注册成功",dto);
        }
    }

    /**
     * 个人信息查询接口
     * @return
     */
    @RequestMapping(value = "info", method = RequestMethod.GET)
    public BaseResult info(Long ouid) {
        OrdinaryUsers ordinaryUsers = ordinaryUsersService.getById(ouid);
        if (ordinaryUsers != null) {
            OrdinaryUsersDTO ordinaryUsersDTOS = new OrdinaryUsersDTO();
            BeanUtils.copyProperties(ordinaryUsers, ordinaryUsersDTOS);
            return BaseResult.success("成功", ordinaryUsersDTOS);
        }
        else {
            return BaseResult.success("失败");
        }
    }

    /**
     * 更新
     * @param ordinaryUsers
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public BaseResult update(OrdinaryUsers ordinaryUsers){
        BaseResult baseResult=ordinaryUsersService.update(ordinaryUsers);
        //更新失败
        if (baseResult.getStatus()==500){
            return BaseResult.fail("用户名或邮箱或手机号已存在");
        }
        //更新成功
        else {
            OrdinaryUsersDTO dto = new OrdinaryUsersDTO();
            BeanUtils.copyProperties(ordinaryUsers, dto);
            return BaseResult.success("信息修改成功",dto);
        }
    }
}
