package com.zz.zhongyuan.e.insurance.web.admin.users.service.impl;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.validator.BeanValidator;
import com.zz.zhongyuan.e.insurance.domain.AdminUsers;
import com.zz.zhongyuan.e.insurance.web.admin.users.dao.AdminUsersDao;
import com.zz.zhongyuan.e.insurance.web.admin.users.service.AdminUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import java.util.Date;
import java.util.List;

/**
 * ClassName: AdminUsersServiceImpl
 * Description: <br/>
 * date: 2020/2/8 22:29
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Service
public class AdminUsersServiceImpl implements AdminUsersService {

    @Autowired
    private AdminUsersDao adminUsersDao;

    /**
     * 管理员通过邮箱和密码登录
     * @param email
     * @param password
     * @return
     */
    @Override
    public AdminUsers login(String email, String password) {
        AdminUsers adminUsers=adminUsersDao.getByEmail(email);
        if (adminUsers!=null){
            //明文密码加密
            String md5Password= DigestUtils.md5DigestAsHex(password.getBytes());
            if (md5Password.equals(adminUsers.getPassword())){
                return adminUsers;
            }
        }
        return null;
    }

    @Override
    public AdminUsers register(AdminUsers adminUsers) {
        List<AdminUsers> adminUsersList=selectAll();
        //遍历所有管理员
        for (AdminUsers adminUser : adminUsersList){
            //手机号和邮箱有一个相同则注册失败
            if (adminUsers.getPhone().equals(adminUser.getPhone()) || adminUsers.getEmail().equals(adminUser.getEmail())){
                return null;
            }
        }
        //给密码加密
        String password=DigestUtils.md5DigestAsHex(adminUsers.getPassword().getBytes());
        adminUsers.setUpdated(new Date());
        adminUsers.setCreated(new Date());
        adminUsers.setPassword(password);
        adminUsers.setState(0);
        adminUsersDao.insert(adminUsers);
        return adminUsers;
    }

    /**
     * 查询数据库中的所有管理员
     * @return
     */
    @Override
    public List<AdminUsers> selectAll() {
        return adminUsersDao.selectAll();
    }

    @Override
    public BaseResult insert(AdminUsers adminUsers) {
        String validator = BeanValidator.validator(adminUsers);
        //验证不通过
        if (validator!=null){
            return BaseResult.fail(validator);
        }
        //验证通过
        else {
            List<AdminUsers> adminUsersList=selectAll();
            //遍历所有管理员
            for (AdminUsers adminUser : adminUsersList){
                //手机号和邮箱有一个相同则失败
                if (adminUsers.getPhone().equals(adminUser.getPhone()) || adminUsers.getEmail().equals(adminUser.getEmail())){
                    return BaseResult.fail("手机号或者邮箱已存在");
                }
            }
            adminUsers.setPassword(DigestUtils.md5DigestAsHex(adminUsers.getPassword().getBytes()));
            adminUsers.setUpdated(new Date());
            update(adminUsers);
            return BaseResult.success("保存用户信息成功");
        }
    }

    @Override
    public void update(AdminUsers adminUsers) {
        adminUsersDao.update(adminUsers);
    }

    @Override
    public AdminUsers getById(Long auid) {
        return adminUsersDao.getById(auid);
    }
}
