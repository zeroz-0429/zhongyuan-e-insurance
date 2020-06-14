package com.zz.zhongyuan.e.insurance.web.ui.dto;

import lombok.Data;


import java.io.Serializable;

/**
 * ClassName: InsuranceCategory
 * Description: <br/>
 * date: 2020/2/16 23:30
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Data
public class InsuranceCategory implements Serializable {
    private Long  icid;
    private String name;
    private String description;
}
