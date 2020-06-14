package com.zz.zhongyuan.e.insurance.web.ui.api;

import com.zz.zhongyuan.e.insurance.commons.utils.HttpClientUtils;
import com.zz.zhongyuan.e.insurance.commons.utils.MapperUtils;
import com.zz.zhongyuan.e.insurance.web.ui.dto.Content;

import java.util.List;

/**
 * ClassName: ContentAPI
 * Description: <br/>
 * date: 2020/4/17 21:24
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public class ContentAPI {
    /**
     * 请求幻灯片
     *
     * @return
     */
    public static List<Content> ppt() {
        List<Content> contents = null;
        String result = HttpClientUtils.doGet(API.API_CONTENT_PPT);
        try {
            contents = MapperUtils.json2listByTree(result, "data", Content.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contents;
    }

    /**
     * 请求公司信息
     *
     * @return
     */
    public static List<Content> companyInfo() {
        List<Content> contents = null;
        String result = HttpClientUtils.doGet(API.API_CONTENT_COMPANY_INFO);
        try {
            contents = MapperUtils.json2listByTree(result, "data", Content.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contents;
    }

    /**
     * 请求公司发展
     *
     * @return
     */
    public static List<Content> companyDev() {
        List<Content> contents = null;
        String result = HttpClientUtils.doGet(API.API_CONTENT_COMPANY_DEV);
        try {
            contents = MapperUtils.json2listByTree(result, "data", Content.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contents;
    }

    /**
     * 请求投保流程
     *
     * @return
     */
    public static List<Content> introduce() {
        List<Content> contents = null;
        String result = HttpClientUtils.doGet(API.API_CONTENT_INTRODUCE);
        try {
            contents = MapperUtils.json2listByTree(result, "data", Content.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contents;
    }
}
