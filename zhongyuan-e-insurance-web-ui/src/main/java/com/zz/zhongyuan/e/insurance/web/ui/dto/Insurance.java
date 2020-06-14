package com.zz.zhongyuan.e.insurance.web.ui.dto;

import com.zz.zhongyuan.e.insurance.domain.InsuranceCategory;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: Insurance
 * Description: <br/>
 * date: 2020/4/19 10:13
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Data
public class Insurance implements Serializable {
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
