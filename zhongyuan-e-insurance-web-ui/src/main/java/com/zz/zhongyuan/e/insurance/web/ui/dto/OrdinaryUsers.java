package com.zz.zhongyuan.e.insurance.web.ui.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: OrdinaryUsers
 * Description: <br/>
 * date: 2020/3/19 22:14
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Data
public class OrdinaryUsers implements Serializable {
    private Long ouid;
    private String username;
    private String password;
    private String phone;
    private String email;
    private int state;
    private String verification;
}
