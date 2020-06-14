package com.zz.zhongyuan.e.insurance.web.admin.users.dao;


import com.zz.zhongyuan.e.insurance.domain.Insurance;
import com.zz.zhongyuan.e.insurance.domain.InsuranceCategory;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * ClassName: Insurance
 * Description: <br/>
 * date: 2020/2/16 21:36
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Repository
public interface InsuranceDao {
    /**
     * 查询所有
     * @return
     */
    public List<Insurance> selectAll();

    /**
     * 查询所有分类类目
     * @return
     */
    public List<InsuranceCategory> selectAllPid();

    /**
     * 查询分类类目id
     * @return
     */
    public Long  selectIcid(String name);

    /**
     * 根据id查询
     * @param iid
     * @return
     */
    public Insurance getById(Long iid);


    /**
     * 新增
     * @param insurance
     */
    public void insert(Insurance insurance);

    /**
     * 删除
     * @param iid
     */
    public void delete(Long iid);


    /**
     * 更新
     * @param insurance
     */
    public void update(Insurance insurance);


    /**
     * 批量删除
     * @param iids
     */
    public void deleteMulti(String[] iids);


    /**
     * 分页查询
     * @param params
     * @return
     */
    public List<Insurance> page(Map<String,Object> params);

    /**
     * 查询总数
     * @return
     */
    public int count(Insurance insurance);
}
