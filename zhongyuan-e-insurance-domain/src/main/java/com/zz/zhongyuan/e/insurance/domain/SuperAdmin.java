package com.zz.zhongyuan.e.insurance.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: SuperAdmin
 * Description: <br/>
 * date: 2020/1/31 14:33
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Data
public class SuperAdmin implements Serializable {
    private String phone;
    private String password;
}
