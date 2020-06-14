package com.zz.zhongyuan.e.insurance.web.api.dao;

import com.zz.zhongyuan.e.insurance.domain.InsuranceFavorite;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: InsuranceFavoriteDao
 * Description: <br/>
 * date: 2020/4/24 20:33
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Repository
public interface InsuranceFavoriteDao {

    /**
     * 查询所有
     * @return
     */
    List<InsuranceFavorite> selectAll();

    /**
     * 根据用户id查询收藏
     * @param ouid
     * @return
     */
    List<InsuranceFavorite> getByOuId(Long ouid);

    /**
     * 加入收藏
     * @param insuranceFavorite
     */
    void insert(InsuranceFavorite insuranceFavorite);

    /**
     * 根据id删除收藏
     * @param iid
     */
    void delete(@Param("iid") Long iid,@Param("ouid") Long ouid);
}
