package com.zz.zhongyuan.e.insurance.web.api.web.dto;

import com.zz.zhongyuan.e.insurance.domain.InsuranceCategory;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: InsuranceDTO
 * Description: <br/>
 * date: 2020/4/17 23:35
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Data
public class InsuranceDTO implements Serializable {
    private Long  iid;
    private String name;
    private String price;
    private String bargainPrice;
    private String content;
    private String pictrue;
    private int isActivity;
    private int state;
    private InsuranceCategory insuranceCategory;
}
