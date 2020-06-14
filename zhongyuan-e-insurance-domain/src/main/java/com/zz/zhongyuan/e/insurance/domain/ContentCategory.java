package com.zz.zhongyuan.e.insurance.domain;

import com.zz.zhongyuan.e.insurance.commons.persistence.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.NotNull;

/**
 * ClassName: ContentCategory
 * Description: <br/>
 * date: 2020/3/22 21:44
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */

public class ContentCategory extends BaseEntity {
    private Long ccid;
//    private Long parentId;
    @NotNull(message = "分类名称不能为空")
    private String name;
    private boolean isParent;
    private ContentCategory parent;

    public Long getCcid() {
        return ccid;
    }

    public void setCcid(Long ccid) {
        this.ccid = ccid;
    }

//    public Long getParentId() {
//        return parentId;
//    }
//
//    public void setParentId(Long parentId) {
//        this.parentId = parentId;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(boolean parent) {
        isParent = parent;
    }

    public ContentCategory getParent() {
        return parent;
    }

    public void setParent(ContentCategory parent) {
        this.parent = parent;
    }
}
