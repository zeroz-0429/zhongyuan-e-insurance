package com.zz.zhongyuan.e.insurance.web.ui.dto;

import com.zz.zhongyuan.e.insurance.domain.Insurance;
import com.zz.zhongyuan.e.insurance.domain.OrdinaryUsers;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: InsuranceFavorite
 * Description: <br/>
 * date: 2020/4/24 22:32
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Data
public class InsuranceFavorite implements Serializable {
    private Long ifid;
    private OrdinaryUsers ordinaryUsers;
    private Insurance insurance;
    private Date created;
}
