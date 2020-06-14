package com.zz.zhongyuan.e.insurance.web.admin.users.service;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.dto.PageInfo;
import com.zz.zhongyuan.e.insurance.domain.Content;
import java.util.List;

/**
 * ClassName: ContentService
 * Description: <br/>
 * date: 2020/3/22 23:25
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public interface ContentService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<Content> selectAll();

    /**
     * 新增
     * @param content
     */
    public BaseResult save(Content content);

    /**
     * 删除
     * @param cid
     */
    public void delete(Long cid);

    /**
     * 根据id查询
     * @param cid
     * @return
     */
    public Content getById(Long cid);

    /**
     * 更新
     * @param content
     */
    public void update(Content content);


    /**
     * 批量删除
     * @param cids
     */
    public void deleteMulti(String[] cids);

    /**
     * 分页查询
     * @param start
     * @param length
     * @return
     */
    public PageInfo<Content> page(int start, int length, int draw, Content content);

    /**
     * 查询总数
     * @return
     */
    public int count(Content content);
}
