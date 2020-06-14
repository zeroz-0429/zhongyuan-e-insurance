package com.zz.zhongyuan.e.insurance.domain;

import com.zz.zhongyuan.e.insurance.commons.persistence.BaseEntity;
import lombok.Data;

/**
 * ClassName: InsuranceFavorite
 * Description: <br/>
 * date: 2020/4/24 14:17
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Data
public class InsuranceFavorite extends BaseEntity {
   private Long ifid;
   private OrdinaryUsers ordinaryUsers;
   private Insurance insurance;
}
