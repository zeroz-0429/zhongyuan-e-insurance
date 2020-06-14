package com.zz.zhongyuan.e.insurance.web.api.web.controller;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.domain.InsuranceCategory;
import com.zz.zhongyuan.e.insurance.web.api.service.InsuranceCategoryService;
import com.zz.zhongyuan.e.insurance.web.api.web.dto.InsuranceCategoryDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: InsuranceCategoryController
 * Description: <br/>
 * date: 2020/4/18 23:11
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@RestController
@RequestMapping(value = "api/insurance")
public class InsuranceCategoryController {
    @Autowired
    private InsuranceCategoryService insuranceCategoryService;

    /**
     * 保险分类接口
     * @return
     */
    @RequestMapping(value = "category", method = RequestMethod.GET)
    public BaseResult findCategoryPid(){
        List<InsuranceCategoryDTO> insuranceCategoryDTOS = null;
        List<InsuranceCategory> insuranceCategories = insuranceCategoryService.selectAll();

        if (insuranceCategories != null && insuranceCategories.size() > 0) {
            insuranceCategoryDTOS = new ArrayList<>();
            for (InsuranceCategory insuranceCategory : insuranceCategories) {
                InsuranceCategoryDTO dto = new InsuranceCategoryDTO();
                BeanUtils.copyProperties(insuranceCategory, dto);
                insuranceCategoryDTOS.add(dto);
            }
        }

        return BaseResult.success("成功", insuranceCategoryDTOS);
    }
}
