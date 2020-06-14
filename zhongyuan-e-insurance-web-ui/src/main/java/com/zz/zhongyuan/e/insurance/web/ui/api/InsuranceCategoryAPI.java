package com.zz.zhongyuan.e.insurance.web.ui.api;

import com.zz.zhongyuan.e.insurance.commons.utils.HttpClientUtils;
import com.zz.zhongyuan.e.insurance.commons.utils.MapperUtils;
import com.zz.zhongyuan.e.insurance.web.ui.dto.InsuranceCategory;

import java.util.List;

/**
 * ClassName: InsuranceCategoryAPI
 * Description: <br/>
 * date: 2020/4/18 23:32
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public class InsuranceCategoryAPI {
    /**
     * 请求幻灯片
     *
     * @return
     */
    public static List<InsuranceCategory> category() {
        List<InsuranceCategory> insuranceCategories = null;
        String result = HttpClientUtils.doGet(API.API_INSURANCE_CATEGORY);
        try {
            insuranceCategories = MapperUtils.json2listByTree(result, "data", InsuranceCategory.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return insuranceCategories;
    }
}
