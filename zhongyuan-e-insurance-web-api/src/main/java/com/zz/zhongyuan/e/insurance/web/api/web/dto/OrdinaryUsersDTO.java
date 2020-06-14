package com.zz.zhongyuan.e.insurance.web.api.web.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: OrdinaryUsersDTO
 * Description: <br/>
 * date: 2020/3/19 21:29
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Data
public class OrdinaryUsersDTO implements Serializable {
    private Long ouid;
    private String username;
    private String password;
    private String phone;
    private String email;
    private int state;
}
