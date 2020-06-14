package com.zz.zhongyuan.e.insurance.web.admin.service.impl;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.dto.PageInfo;
import com.zz.zhongyuan.e.insurance.commons.validator.BeanValidator;
import com.zz.zhongyuan.e.insurance.domain.AdminUsers;
import com.zz.zhongyuan.e.insurance.web.admin.dao.AdminUsersDao;
import com.zz.zhongyuan.e.insurance.web.admin.service.AdminUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: AdminUsersServiceImpl
 * Description: <br/>
 * date: 2020/2/1 22:37
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Service
public class AdminUsersServiceImpl implements AdminUsersService {

    @Autowired
    private AdminUsersDao adminUsersDao;

    @Override
    public List<AdminUsers> selectAll() {
        return adminUsersDao.selectAll();
    }

    @Override
    public AdminUsers getById(Long auid) {
        return adminUsersDao.getById(auid);
    }

    @Override
    public BaseResult save(AdminUsers adminUsers) {
        String validator = BeanValidator.validator(adminUsers);
        //验证不通过
        if (validator!=null){
            return BaseResult.fail(validator);
        }
        //验证通过
        else {
            adminUsers.setUpdated(new Date());
            //新增用户
            if (adminUsers.getAuid()==null){
                adminUsers.setPassword(DigestUtils.md5DigestAsHex(adminUsers.getPassword().getBytes()));
                adminUsers.setCreated(new Date());
                adminUsersDao.insert(adminUsers);
            }
            //编辑用户
            else {
                update(adminUsers);
            }
            return BaseResult.success("保存管理员用户信息成功");
        }
    }

    @Override
    public void delete(Long auid) {
        adminUsersDao.delete(auid);
    }

    @Override
    public void deleteMulti(String[] auids) {
        adminUsersDao.deleteMulti(auids);
    }

    @Override
    public void update(AdminUsers adminUsers) {
        adminUsersDao.update(adminUsers);
    }

    @Override
    public PageInfo<AdminUsers> page(int start, int length, int draw, AdminUsers adminUsers) {
        int count = count(adminUsers);

        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", adminUsers);

        PageInfo<AdminUsers> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(adminUsersDao.page(params));

        return pageInfo;
    }

    @Override
    public int count(AdminUsers adminUsers) {
        return adminUsersDao.count(adminUsers);
    }
}
