package com.zz.zhongyuan.e.insurance.web.api.service.impl;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.domain.OrdinaryUsers;
import com.zz.zhongyuan.e.insurance.web.api.dao.OrdinaryUsersDao;
import com.zz.zhongyuan.e.insurance.web.api.service.OrdinaryUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import java.util.Date;
import java.util.List;

/**
 * ClassName: OrdinaryUsersServiceImpl
 * Description: <br/>
 * date: 2020/3/19 21:18
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Service
public class OrdinaryUsersServiceImpl implements OrdinaryUsersService {
    @Autowired
    private OrdinaryUsersDao ordinaryUsersDao;
    @Override
    public OrdinaryUsers login(OrdinaryUsers ordinaryUsers) {
        OrdinaryUsers user = ordinaryUsersDao.login(ordinaryUsers);
        if (user != null) {
            // 将明文密码加密
            String password = DigestUtils.md5DigestAsHex(ordinaryUsers.getPassword().getBytes());
            if (password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public BaseResult register(OrdinaryUsers ordinaryUsers) {
        List<OrdinaryUsers> ordinaryUser=selectAll();
        for (OrdinaryUsers Users : ordinaryUser){
            if (ordinaryUsers.getUsername().equals(Users.getUsername()) || ordinaryUsers.getEmail().equals(Users.getEmail()) || ordinaryUsers.getPhone().equals(Users.getPhone())){
                return BaseResult.fail("保存用户信息失败");
            }
        }
        String password=DigestUtils.md5DigestAsHex(ordinaryUsers.getPassword().getBytes());
        ordinaryUsers.setUpdated(new Date());
        ordinaryUsers.setCreated(new Date());
        ordinaryUsers.setState(1);
        ordinaryUsers.setPassword(password);
        ordinaryUsersDao.register(ordinaryUsers);
        return BaseResult.success("保存用户信息成功");
    }

    @Override
    public List<OrdinaryUsers> selectAll() {
        return ordinaryUsersDao.selectAll();
    }

    @Override
    public OrdinaryUsers getById(Long ouid) {
        return ordinaryUsersDao.getById(ouid);
    }

    @Override
    public BaseResult update(OrdinaryUsers ordinaryUsers) {
        List<OrdinaryUsers> ordinaryUser=selectAll();
        for (OrdinaryUsers Users : ordinaryUser){
            if (ordinaryUsers.getUsername().equals(Users.getUsername()) || ordinaryUsers.getEmail().equals(Users.getEmail()) || ordinaryUsers.getPhone().equals(Users.getPhone())){
                return BaseResult.fail("保存用户信息失败");
            }
        }
        String password=DigestUtils.md5DigestAsHex(ordinaryUsers.getPassword().getBytes());
        ordinaryUsers.setUpdated(new Date());
        ordinaryUsers.setPassword(password);
        ordinaryUsers.setState(1);
        ordinaryUsersDao.update(ordinaryUsers);
        return BaseResult.success("保存用户信息成功");
    }
}
