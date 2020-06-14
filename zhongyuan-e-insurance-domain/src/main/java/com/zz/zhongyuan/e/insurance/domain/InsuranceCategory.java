package com.zz.zhongyuan.e.insurance.domain;

import com.zz.zhongyuan.e.insurance.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

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
public class InsuranceCategory extends BaseEntity {
    private Long  icid;
    @Length(min = 2, max = 20, message = "分类名称长度必须介于 2 和 20 之间")
    private String name;
    @Length(min = 2, max = 20, message = "分类描述度必须介于 2 和 20 之间")
    private String description;
}
