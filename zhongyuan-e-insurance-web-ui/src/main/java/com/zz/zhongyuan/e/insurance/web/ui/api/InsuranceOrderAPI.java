package com.zz.zhongyuan.e.insurance.web.ui.api;

import com.zz.zhongyuan.e.insurance.commons.utils.HttpClientUtils;
import com.zz.zhongyuan.e.insurance.commons.utils.MapperUtils;
import com.zz.zhongyuan.e.insurance.web.ui.dto.Insurance;
import com.zz.zhongyuan.e.insurance.web.ui.dto.InsuranceOrder;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: InsuranceOrderAPI
 * Description: <br/>
 * date: 2020/4/21 23:06
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public class InsuranceOrderAPI {
    /**
     * 请求某个用户下的所有保单
     *
     * @return
     */
    public static List<InsuranceOrder> orderList(Long ouid) {
        List<InsuranceOrder> insuranceOrders = null;
        String result = HttpClientUtils.doGet(API.API_INSURANCE_ORDER_LIST+ouid);
        try {
            insuranceOrders = MapperUtils.json2listByTree(result, "data", InsuranceOrder.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return insuranceOrders;
    }

    /**
     * 提交保单
     * @param insuranceOrder
     * @return
     */
    public static InsuranceOrder orderUp(InsuranceOrder insuranceOrder) throws Exception{
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("ordinaryUsers.ouid", insuranceOrder.getOrdinaryUsers().getOuid().toString()));
        params.add(new BasicNameValuePair("name", insuranceOrder.getName()));
        params.add(new BasicNameValuePair("identityCard", insuranceOrder.getIdentityCard()));
        params.add(new BasicNameValuePair("phone", insuranceOrder.getPhone()));
        params.add(new BasicNameValuePair("insurance.iid", insuranceOrder.getInsurance().getIid().toString()));

        String json = HttpClientUtils.doPost(API.API_INSURANCE_ORDER_LIST_UP, params.toArray(new BasicNameValuePair[params.size()]));
        InsuranceOrder order = MapperUtils.json2pojoByTree(json, "data", InsuranceOrder.class);
        return order;
    }
}
