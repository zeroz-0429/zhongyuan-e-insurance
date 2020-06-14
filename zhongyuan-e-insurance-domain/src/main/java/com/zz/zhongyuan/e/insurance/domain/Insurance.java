package com.zz.zhongyuan.e.insurance.domain;

import com.zz.zhongyuan.e.insurance.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * ClassName: Insurance
 * Description: <br/>
 * date: 2020/2/16 23:25
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Data
public class Insurance extends BaseEntity {
    private Long  iid;
    @Length(min = 1,max = 20,message = "名称长度介于1-20个字符之间")
    private String name;
    @Length(min =1,message = "价格不能为空")
    private String price;
    private String bargainPrice;
    @Length(min =1,message = "详情内容不能为空")
    private String content;
    private String pictrue;
    private int isActivity;
    private int state;
    @NotNull(message = "父级目录不能为空")
    private InsuranceCategory insuranceCategory;
}
