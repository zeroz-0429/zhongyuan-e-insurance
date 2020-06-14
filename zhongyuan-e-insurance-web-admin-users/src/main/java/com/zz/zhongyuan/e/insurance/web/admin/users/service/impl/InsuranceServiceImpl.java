package com.zz.zhongyuan.e.insurance.web.admin.users.service.impl;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.dto.PageInfo;
import com.zz.zhongyuan.e.insurance.commons.validator.BeanValidator;
import com.zz.zhongyuan.e.insurance.domain.AdminUsers;
import com.zz.zhongyuan.e.insurance.domain.Insurance;
import com.zz.zhongyuan.e.insurance.domain.InsuranceCategory;
import com.zz.zhongyuan.e.insurance.web.admin.users.dao.InsuranceDao;
import com.zz.zhongyuan.e.insurance.web.admin.users.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: InsuranceServiceImpl
 * Description: <br/>
 * date: 2020/2/16 22:44
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    private InsuranceDao insuranceDao;

    @Override
    public List<Insurance> selectAll() {
        return insuranceDao.selectAll();
    }

    @Override
    public List<InsuranceCategory> selectAllPid() {
        return insuranceDao.selectAllPid();
    }

    @Override
    public Long selectIcid(String name) {
        return insuranceDao.selectIcid(name);
    }

    @Override
    public Insurance getById(Long iid) {
        return insuranceDao.getById(iid);
    }

    @Override
    public BaseResult save(Insurance insurance) {
        String validator = BeanValidator.validator(insurance);
        //验证不通过
        if (validator!=null){
            return BaseResult.fail(validator);
        }
        //验证通过
        else {
            insurance.setUpdated(new Date());
            //新增
            if (insurance.getIid()==null){
                InsuranceCategory insuranceCategory=new InsuranceCategory();
                insuranceCategory.setIcid(selectIcid(insurance.getInsuranceCategory().getName()));
                insurance.setInsuranceCategory(insuranceCategory);
                insurance.setCreated(new Date());
                insuranceDao.insert(insurance);
            }
            //编辑
            else {
                update(insurance);
            }
            return BaseResult.success("保存保险信息成功");
        }
    }

    @Override
    public void delete(Long iid) {
        insuranceDao.delete(iid);
    }


    @Override
    public void update(Insurance insurance) {
        insuranceDao.update(insurance);
    }

    @Override
    public void deleteMulti(String[] iids) {
        insuranceDao.deleteMulti(iids);
    }

    @Override
    public PageInfo<Insurance> page(int start, int length, int draw, Insurance insurance) {
        int count = count(insurance);

        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", insurance);

        PageInfo<Insurance> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(insuranceDao.page(params));

        return pageInfo;
    }

    @Override
    public int count(Insurance insurance) {
        return insuranceDao.count(insurance);
    }
}
