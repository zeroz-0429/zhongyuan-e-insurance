package com.zz.zhongyuan.e.insurance.web.api.web.dto;

import com.zz.zhongyuan.e.insurance.domain.Insurance;
import com.zz.zhongyuan.e.insurance.domain.OrdinaryUsers;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: InsuranceFavoriteDTO
 * Description: <br/>
 * date: 2020/4/24 20:52
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Data
public class InsuranceFavoriteDTO implements Serializable {
    private Long ifid;
    private OrdinaryUsers ordinaryUsers;
    private Insurance insurance;
    private Date created;
}
