package com.zz.zhongyuan.e.insurance.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zz.zhongyuan.e.insurance.commons.persistence.BaseEntity;
import com.zz.zhongyuan.e.insurance.commons.utils.RegexpUtils;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

/**
 * ClassName: OrdinaryUsers
 * Description: <br/>
 * date: 2020/2/16 23:21
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Data
public class OrdinaryUsers extends BaseEntity {
    private Long ouid;
    @Length(min = 6, max = 20, message = "用户名长度必须介于 6 和 20 之间")
    private String username;
    @JsonIgnore
    @Length(min = 6, max = 20, message = "密码长度必须介于 6 和 20 之间")
    private String password;
    @Pattern(regexp = RegexpUtils.PHONE, message = "手机号格式不正确")
    private String phone;
    @Pattern(regexp = RegexpUtils.EMAIL, message = "邮箱格式不正确")
    private String email;
    private int state;
}
