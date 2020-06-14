package com.zz.zhongyuan.e.insurance.web.ui.api;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.utils.HttpClientUtils;
import com.zz.zhongyuan.e.insurance.commons.utils.MapperUtils;
import com.zz.zhongyuan.e.insurance.web.ui.dto.InsuranceFavorite;
import com.zz.zhongyuan.e.insurance.web.ui.dto.InsuranceOrder;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: InsuranceFavoriteAPI
 * Description: <br/>
 * date: 2020/4/24 22:31
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public class InsuranceFavoriteAPI {
    /**
     * 请求某个用户下的所有收藏
     *
     * @return
     */
    public static List<InsuranceFavorite> favoriteList(Long ouid) {
        List<InsuranceFavorite> insuranceFavorites = null;
        String result = HttpClientUtils.doGet(API.API_INSURANCE_FAVORITE_LIST+ouid);
        try {
            insuranceFavorites = MapperUtils.json2listByTree(result, "data", InsuranceFavorite.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return insuranceFavorites;
    }

    /**
     * 加入收藏
     * @param insuranceFavorite
     * @return
     */
    public static InsuranceFavorite favoriteUp(InsuranceFavorite insuranceFavorite) throws Exception{
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("ordinaryUsers.ouid", insuranceFavorite.getOrdinaryUsers().getOuid().toString()));
        params.add(new BasicNameValuePair("insurance.iid", insuranceFavorite.getInsurance().getIid().toString()));

        String json = HttpClientUtils.doPost(API.API_INSURANCE_FAVORITE_INSERT, params.toArray(new BasicNameValuePair[params.size()]));
        InsuranceFavorite favorite = MapperUtils.json2pojoByTree(json, "data", InsuranceFavorite.class);
        return favorite;
    }

    /**
     * 取消收藏
     * @param iid
     * @return
     */
    public static BaseResult deleteFavorite(Long iid,Long ouid){
        String json = HttpClientUtils.doGet(API.API_INSURANCE_FAVORITE_DELETE+"iid="+iid+"&"+"ouid="+ouid);
        return BaseResult.success("删除成功",json);
    }
}
