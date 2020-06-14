package com.zz.zhongyuan.e.insurance.domain;

import com.zz.zhongyuan.e.insurance.commons.persistence.BaseEntity;
import com.zz.zhongyuan.e.insurance.commons.utils.RegexpUtils;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

/**
 * ClassName: InsuranceOrders
 * Description: <br/>
 * date: 2020/2/16 23:32
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Data
public class InsuranceOrders extends BaseEntity {
    private Long ioid;
    @Length(min = 1,max = 6,message = "姓名长度介于1-6个字符之间")
    private String name;
    @Pattern(regexp = RegexpUtils.CARD, message = "身份证格式不正确")
    private String identityCard;
    @Pattern(regexp = RegexpUtils.PHONE, message = "手机号格式不正确")
    private String phone;
    private int state;
    private OrdinaryUsers ordinaryUsers;
    private Insurance insurance;
}
