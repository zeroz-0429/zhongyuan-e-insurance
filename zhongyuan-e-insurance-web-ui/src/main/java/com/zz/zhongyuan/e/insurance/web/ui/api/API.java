package com.zz.zhongyuan.e.insurance.web.ui.api;

/**
 * ClassName: API
 * Description: <br/>
 * date: 2020/3/19 22:19
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public class API {
    // 主机地址
    public static final String HOST = "http://localhost:8092/api";

    // 普通用户管理接口 - 登录
    public static final String API_USERS_LOGIN = HOST + "/ordinary_users/login";

    //普通用户管理接口 -注册
    public static final String API_USERS_REGISTER = HOST + "/ordinary_users/register";

    // 内容查询接口 - 幻灯片
    public static final String API_CONTENT_PPT = HOST + "/content/ppt";

    //内容查询接口 - 公司信息
    public static final String API_CONTENT_COMPANY_INFO = HOST + "/content/company_info";

    //内容查询接口 - 公司发展
    public static final String API_CONTENT_COMPANY_DEV = HOST + "/content/company_dev";

    //内容查询接口 - 投保流程
    public static final String API_CONTENT_INTRODUCE = HOST + "/content/introduce";

    //内容查询接口 -保险分类
    public static final String API_INSURANCE_CATEGORY = HOST + "/insurance/category";

    //内容查询接口 -保险分类列表
    public static final String API_CONTENTS_LIST = HOST + "/insurance/list?categoryId=";

    //单个产品信息查询借口呢
    public static final String API_INSURANCE_PRODUCT = HOST + "/insurance/product?iid=";

    //个人信息查询接口
    public static final String API_PERSONAL_INFO = HOST + "/ordinary_users/info?ouid=";

    //个人信息修改接口
    public static final String API_PERSONAL_UPDATE = HOST + "/ordinary_users/update";

    //根据用户id查询保单
    public static final String API_INSURANCE_ORDER_LIST = HOST + "/insurance/order/list?ouid=";

    //提交用户保单
    public static final String API_INSURANCE_ORDER_LIST_UP = HOST + "/insurance/order/order_list";

    //模糊查询保险接口
    public static final String API_INSURANCE_SEARCH = HOST + "/insurance/search?name=";

    //活动保险接口
    public static final String API_INSURANCE_ACTIVITY = HOST + "/insurance/activity";

    //产品收藏查询接口
    public static final String API_INSURANCE_FAVORITE_LIST = HOST + "/favorite/list?ouid=";

    //加入收藏接口
    public static final String API_INSURANCE_FAVORITE_INSERT = HOST + "/favorite/insert";

    //取消收藏接口
    public static final String API_INSURANCE_FAVORITE_DELETE = HOST + "/favorite/delete?";
}
