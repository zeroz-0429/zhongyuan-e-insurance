package com.zz.zhongyuan.e.insurance.web.api.dao;

import com.zz.zhongyuan.e.insurance.domain.InsuranceCategory;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * ClassName: InsuranceCategoryDao
 * Description: <br/>
 * date: 2020/4/18 22:59
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Repository
public interface InsuranceCategoryDao {
    /**
     * 查询所有分类
     * @return
     */
    public List<InsuranceCategory> selectAll();
}
