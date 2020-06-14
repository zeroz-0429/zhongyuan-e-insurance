package com.zz.zhongyuan.e.insurance.domain;
import com.zz.zhongyuan.e.insurance.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

/**
 * ClassName: Content
 * Description: <br/>
 * date: 2020/3/22 21:44
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Data
public class Content extends BaseEntity {
    private Long cid;
    @Length(min = 1,max = 20,message = "标题长度介于1-20个字符之间")
    private String title;
    @Length(min = 1,max = 20,message = "标题描述长度介于1-20个字符之间")
    private String titleDesc;
    private String pictrue;
    @Length(min = 1,message = "内容长度必须大于1")
    private String content;
    @NotNull(message = "父级目录不能为空")
    private ContentCategory contentCategory;
}
