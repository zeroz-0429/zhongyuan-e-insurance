package com.zz.zhongyuan.e.insurance.web.admin.users.dao;

import com.zz.zhongyuan.e.insurance.domain.Content;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * ClassName: ContentDao
 * Description: <br/>
 * date: 2020/3/22 21:34
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Repository
public interface ContentDao {
    /**
     * 查询所有信息
     * @return
     */
    public List<Content> selectAll();

    /**
     * 新增
     * @param content
     */
    public void insert(Content content);

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
     * @param params
     * @return
     */
    public List<Content> page(Map<String,Object> params);

    /**
     * 查询总数
     * @return
     */
    public int count(Content content);
}
