package com.zz.zhongyuan.e.insurance.domain;

import com.zz.zhongyuan.e.insurance.commons.persistence.BaseEntity;
import com.zz.zhongyuan.e.insurance.commons.utils.RegexpUtils;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

/**
 * ClassName: AdminUsers
 * Description: <br/>
 * date: 2020/2/2 20:52
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Data
public class AdminUsers extends BaseEntity {
    private Long auid;
    @Pattern(regexp = RegexpUtils.PHONE, message = "手机号格式不正确")
    private String phone;
    @Pattern(regexp = RegexpUtils.EMAIL, message = "邮箱格式不正确")
    private String email;
    @Length(min = 6, max = 20, message = "密码长度必须介于 6 和 20 之间")
    private String password;
    private int state;
}
