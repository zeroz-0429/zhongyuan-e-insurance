package com.zz.zhongyuan.e.insurance.web.admin.users.service;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.dto.PageInfo;
import com.zz.zhongyuan.e.insurance.domain.Content;
import com.zz.zhongyuan.e.insurance.domain.Insurance;
import com.zz.zhongyuan.e.insurance.domain.InsuranceCategory;

import java.util.List;

/**
 * ClassName: InsuranceService
 * Description: <br/>
 * date: 2020/2/16 22:39
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public interface InsuranceService {
    /**
     * 查询所有管理员信息
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
    public Long selectIcid(String name);

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
    public BaseResult save(Insurance insurance);

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
     * @param start
     * @param length
     * @return
     */
    public PageInfo<Insurance> page(int start, int length, int draw, Insurance insurance);

    /**
     * 查询总数
     * @return
     */
    public int count(Insurance insurance);
}
