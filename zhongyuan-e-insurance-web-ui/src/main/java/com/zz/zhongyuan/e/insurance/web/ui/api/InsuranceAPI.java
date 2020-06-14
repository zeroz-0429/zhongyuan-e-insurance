package com.zz.zhongyuan.e.insurance.web.ui.api;

import com.zz.zhongyuan.e.insurance.commons.utils.HttpClientUtils;
import com.zz.zhongyuan.e.insurance.commons.utils.MapperUtils;
import com.zz.zhongyuan.e.insurance.web.ui.dto.Insurance;

import java.util.List;

/**
 * ClassName: InsuranceAPI
 * Description: <br/>
 * date: 2020/4/19 10:03
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public class InsuranceAPI {
    /**
     * 请求某个分类下的所有商品
     *
     * @return
     */
    public static List<Insurance> list(Long categoryId) {
        List<Insurance> insurances = null;
        String result = HttpClientUtils.doGet(API.API_CONTENTS_LIST+categoryId);
        try {
            insurances = MapperUtils.json2listByTree(result, "data", Insurance.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return insurances;
    }

    /**
     * 请求单个产品的所有信息
     *
     * @return
     */
    public static List<Insurance> product(Long iid) {
        List<Insurance> insurances = null;
        String result = HttpClientUtils.doGet(API.API_INSURANCE_PRODUCT+iid);
        try {
            insurances = MapperUtils.json2listByTree(result, "data", Insurance.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return insurances;
    }

    /**
     * 模糊查询
     *
     * @return
     */
    public static List<Insurance> searchName(String name) {
        List<Insurance> insurances = null;
        String result = HttpClientUtils.doGet(API.API_INSURANCE_SEARCH+name);
        try {
            insurances = MapperUtils.json2listByTree(result, "data", Insurance.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return insurances;
    }

    /**
     * 请求活动产品的所有信息
     *
     * @return
     */
    public static List<Insurance> isActivity() {
        List<Insurance> insurances = null;
        String result = HttpClientUtils.doGet(API.API_INSURANCE_ACTIVITY);
        try {
            insurances = MapperUtils.json2listByTree(result, "data", Insurance.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return insurances;
    }
}
