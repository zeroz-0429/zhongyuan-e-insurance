package com.zz.zhongyuan.e.insurance.commons.persistence;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: BaseEntity
 * Description: <br/>
 * date: 2020/2/2 23:14
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Data
public class BaseEntity implements Serializable {
    private Date created;
    private Date updated;
}
