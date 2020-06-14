package com.zz.zhongyuan.e.insurance.web.api.web.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: InsuranceCategoryDTO
 * Description: <br/>
 * date: 2020/4/18 23:18
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Data
public class InsuranceCategoryDTO implements Serializable {
    private Long  icid;
    private String name;
    private String description;
}
