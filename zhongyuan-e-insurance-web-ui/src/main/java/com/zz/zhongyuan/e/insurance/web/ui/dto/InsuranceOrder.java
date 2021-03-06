package com.zz.zhongyuan.e.insurance.web.ui.dto;

import com.zz.zhongyuan.e.insurance.domain.Insurance;
import com.zz.zhongyuan.e.insurance.domain.OrdinaryUsers;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: InsuranceOrder
 * Description: <br/>
 * date: 2020/4/21 23:06
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Data
public class InsuranceOrder implements Serializable {
    private Long ioid;
    private String name;
    private String identityCard;
    private String phone;
    private int state;
    private OrdinaryUsers ordinaryUsers;
    private Insurance insurance;
    private Date created;
    private Date updated;
}
