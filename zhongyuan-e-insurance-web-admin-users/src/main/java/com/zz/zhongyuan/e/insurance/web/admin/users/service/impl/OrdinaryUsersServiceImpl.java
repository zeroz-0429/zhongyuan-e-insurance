package com.zz.zhongyuan.e.insurance.web.admin.users.service.impl;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.dto.PageInfo;
import com.zz.zhongyuan.e.insurance.commons.validator.BeanValidator;
import com.zz.zhongyuan.e.insurance.domain.AdminUsers;
import com.zz.zhongyuan.e.insurance.domain.OrdinaryUsers;
import com.zz.zhongyuan.e.insurance.web.admin.users.dao.OrdinaryUsersDao;
import com.zz.zhongyuan.e.insurance.web.admin.users.service.OrdinaryUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: OrdinaryUsersServiceImpl
 * Description: <br/>
 * date: 2020/2/16 22:45
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
    public List<OrdinaryUsers> selectAll() {
        return ordinaryUsersDao.selectAll();
    }

    @Override
    public OrdinaryUsers getById(Long ouid) {
        return ordinaryUsersDao.getById(ouid);
    }

    @Override
    public BaseResult save(OrdinaryUsers ordinaryUsers) {
        String validator = BeanValidator.validator(ordinaryUsers);
        //验证不通过
        if (validator!=null){
            return BaseResult.fail(validator);
        }
        //验证通过
        else {
            ordinaryUsers.setUpdated(new Date());
            //新增用户
            if (ordinaryUsers.getOuid()==null){
                ordinaryUsers.setPassword(DigestUtils.md5DigestAsHex(ordinaryUsers.getPassword().getBytes()));
                ordinaryUsers.setCreated(new Date());
                ordinaryUsersDao.insert(ordinaryUsers);
            }
            //编辑用户
            else {
                update(ordinaryUsers);
            }
            return BaseResult.success("保存普通用户信息成功");
        }
    }

    @Override
    public void delete(Long ouid) {
        ordinaryUsersDao.delete(ouid);
    }

    @Override
    public void deleteMulti(String[] ouids) {
        ordinaryUsersDao.deleteMulti(ouids);
    }

    @Override
    public void update(OrdinaryUsers ordinaryUsers) {
        ordinaryUsersDao.update(ordinaryUsers);
    }

    @Override
    public PageInfo<OrdinaryUsers> page(int start, int length, int draw, OrdinaryUsers ordinaryUsers) {
        int count = count(ordinaryUsers);

        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", ordinaryUsers);

        PageInfo<OrdinaryUsers> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(ordinaryUsersDao.page(params));

        return pageInfo;
    }

    @Override
    public int count(OrdinaryUsers ordinaryUsers) {
        return ordinaryUsersDao.count(ordinaryUsers);
    }
}
