package com.zz.zhongyuan.e.insurance.web.ui.api;

import com.zz.zhongyuan.e.insurance.commons.utils.HttpClientUtils;
import com.zz.zhongyuan.e.insurance.commons.utils.MapperUtils;
import com.zz.zhongyuan.e.insurance.web.ui.dto.OrdinaryUsers;
import org.apache.http.message.BasicNameValuePair;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: OrdinaryUsersAPI
 * Description: <br/>
 * date: 2020/3/19 22:19
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public class OrdinaryUsersAPI {
    /**
     * 登录
     * @param ordinaryUsers
     * @return
     */
    public static OrdinaryUsers login(OrdinaryUsers ordinaryUsers) throws Exception {
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username", ordinaryUsers.getUsername()));
        params.add(new BasicNameValuePair("password", ordinaryUsers.getPassword()));

        String json = HttpClientUtils.doPost(API.API_USERS_LOGIN, params.toArray(new BasicNameValuePair[params.size()]));
        OrdinaryUsers users = MapperUtils.json2pojoByTree(json, "data", OrdinaryUsers.class);
        return users;
    }

    /**
     * 注册
     * @param ordinaryUsers
     * @return
     */
    public static OrdinaryUsers register(OrdinaryUsers ordinaryUsers) throws Exception{
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username", ordinaryUsers.getUsername()));
        params.add(new BasicNameValuePair("password", ordinaryUsers.getPassword()));
        params.add(new BasicNameValuePair("phone", ordinaryUsers.getPhone()));
        params.add(new BasicNameValuePair("email", ordinaryUsers.getEmail()));

        String json = HttpClientUtils.doPost(API.API_USERS_REGISTER, params.toArray(new BasicNameValuePair[params.size()]));
        OrdinaryUsers users = MapperUtils.json2pojoByTree(json, "data", OrdinaryUsers.class);
        return users;
    }

    /**
     * 请求个人信息
     *
     * @return
     */
    public static OrdinaryUsers personal_info(Long ouid) {
        OrdinaryUsers ordinaryUsers = null;
        String result = HttpClientUtils.doGet(API.API_PERSONAL_INFO+ouid);
        try {
            ordinaryUsers = MapperUtils.json2pojoByTree(result, "data", OrdinaryUsers.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ordinaryUsers;
    }


    /**
     * 修改个人信息
     * @param ordinaryUsers
     * @return
     */
    public static OrdinaryUsers update_info(OrdinaryUsers ordinaryUsers) throws Exception{
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username", ordinaryUsers.getUsername()));
        params.add(new BasicNameValuePair("password", ordinaryUsers.getPassword()));
        params.add(new BasicNameValuePair("phone", ordinaryUsers.getPhone()));
        params.add(new BasicNameValuePair("email", ordinaryUsers.getEmail()));

        String json = HttpClientUtils.doPost(API.API_PERSONAL_UPDATE, params.toArray(new BasicNameValuePair[params.size()]));
        OrdinaryUsers users = MapperUtils.json2pojoByTree(json, "data", OrdinaryUsers.class);
        return users;
    }
}
