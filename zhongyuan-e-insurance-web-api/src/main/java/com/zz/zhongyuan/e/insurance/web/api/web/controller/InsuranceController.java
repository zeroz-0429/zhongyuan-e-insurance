package com.zz.zhongyuan.e.insurance.web.api.web.controller;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.domain.Content;
import com.zz.zhongyuan.e.insurance.domain.Insurance;
import com.zz.zhongyuan.e.insurance.web.api.service.InsuranceService;
import com.zz.zhongyuan.e.insurance.web.api.web.dto.ContentDTO;
import com.zz.zhongyuan.e.insurance.web.api.web.dto.InsuranceDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: InsuranceController
 * Description: <br/>
 * date: 2020/4/17 23:36
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@RestController
@RequestMapping(value = "/api/insurance")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    /**
     * 保险列表接口
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public BaseResult list(Long categoryId) {
        List<InsuranceDTO> insuranceDTOS = null;
        List<Insurance> insurances = insuranceService.selectByCategoryId(categoryId);
        if (insurances != null && insurances.size() > 0) {
            insuranceDTOS = new ArrayList<>();
            for (Insurance insurance : insurances) {
                InsuranceDTO dto = new InsuranceDTO();
                BeanUtils.copyProperties(insurance, dto);
                insuranceDTOS.add(dto);
            }
        }
        return BaseResult.success("成功", insuranceDTOS);
    }

    /**
     * 单个商品查询接口
     * @return
     */
    @RequestMapping(value = "product", method = RequestMethod.GET)
    public BaseResult product(Long iid) {
        List<InsuranceDTO> insuranceDTOS = null;
        List<Insurance> insurances = insuranceService.getById(iid);
        if (insurances != null && insurances.size() > 0) {
            insuranceDTOS = new ArrayList<>();
            for (Insurance insurance : insurances) {
                InsuranceDTO dto = new InsuranceDTO();
                BeanUtils.copyProperties(insurance, dto);
                insuranceDTOS.add(dto);
            }
        }
        return BaseResult.success("成功", insuranceDTOS);
    }

    /**
     * 商品搜索接口
     * @return
     */
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public BaseResult search(String  name) {
        List<InsuranceDTO> insuranceDTOS = null;
        List<Insurance> insurances = insuranceService.getByName(name);
        if (insurances != null && insurances.size() > 0) {
            insuranceDTOS = new ArrayList<>();
            for (Insurance insurance : insurances) {
                InsuranceDTO dto = new InsuranceDTO();
                BeanUtils.copyProperties(insurance, dto);
                insuranceDTOS.add(dto);
            }
        }
        return BaseResult.success("成功", insuranceDTOS);
    }

    /**
     * 商品活动接口
     * @return
     */
    @RequestMapping(value = "activity", method = RequestMethod.GET)
    public BaseResult activity() {
        List<InsuranceDTO> insuranceDTOS = null;
        List<Insurance> insurances = insuranceService.getByActivity();
        if (insurances != null && insurances.size() > 0) {
            insuranceDTOS = new ArrayList<>();
            for (Insurance insurance : insurances) {
                InsuranceDTO dto = new InsuranceDTO();
                BeanUtils.copyProperties(insurance, dto);
                insuranceDTOS.add(dto);
            }
        }
        return BaseResult.success("成功", insuranceDTOS);
    }

}
