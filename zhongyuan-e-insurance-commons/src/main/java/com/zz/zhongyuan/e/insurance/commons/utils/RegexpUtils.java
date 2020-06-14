package com.zz.zhongyuan.e.insurance.commons.utils;

/**
 * ClassName: RegexpUtils
 * Description: <br/>
 * date: 2019/11/14 16:27
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public class RegexpUtils {
    /**
     * 验证手机号
     */
    public static final String PHONE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    /**
     * 验证邮箱地址
     */
    public static final String EMAIL = "\\w+(\\.\\w)*@\\w+(\\.\\w{2,3}){1,3}";

    /**
     * 验证身份证
     */
    public static final String CARD = "/^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$/";

    /**
     * 验证手机号
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone) {
        return phone.matches(PHONE);
    }

    /**
     * 验证邮箱
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        return email.matches(EMAIL);
    }

    /**
     * 验证邮箱
     * @param email
     * @return
     */
    public static boolean checkCard(String email) {
        return email.matches(CARD);
    }
}
