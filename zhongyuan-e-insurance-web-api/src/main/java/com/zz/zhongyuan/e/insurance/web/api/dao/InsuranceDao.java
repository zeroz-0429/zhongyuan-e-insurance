package com.zz.zhongyuan.e.insurance.web.api.dao;

import com.zz.zhongyuan.e.insurance.domain.Insurance;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: InsuranceDao
 * Description: <br/>
 * date: 2020/4/17 23:34
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Repository
public interface InsuranceDao {
    /**
     * 根据类别 ID 查询保险内容列表
     * @param insurance
     * @return
     */
    List<Insurance> selectByCategoryId(Insurance insurance);

    /**
     * 根据id查询商品信息
     * @param iid
     * @return
     */
    List<Insurance> getById(Long  iid);

    /**
     * 根据名称查询商品信息
     * @param name
     * @return
     */
    List<Insurance> getByName(String  name);

    /**
     * 根据活动情况查询商品信息
     * @param
     * @return
     */
    List<Insurance> getByActivity();


}
