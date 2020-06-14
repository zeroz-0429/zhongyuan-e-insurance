package com.zz.zhongyuan.e.insurance.web.admin.users.dao;

import com.zz.zhongyuan.e.insurance.domain.ContentCategory;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * ClassName: ContentCategoryDao
 * Description: <br/>
 * date: 2020/3/22 21:31
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Repository
public interface ContentCategoryDao {
    /**
     * 查询所有信息
     * @return
     */
    public List<ContentCategory> selectAll();

    /**
     * 新增
     * @param contentCategory
     */
    public void insert(ContentCategory contentCategory);

    /**
     * 删除
     *
     * @param ccid
     */
    void delete(Long  ccid);

    /**
     * 根据id查询
     * @param ccid
     * @return
     */
    public ContentCategory getById(Long ccid);

    /**
     * 更新
     * @param contentCategory
     */
    public void update(ContentCategory contentCategory);
    /**
     * 根据父级节点ID查询所有子节点
     * @param pid
     * @return
     */
    public List<ContentCategory> selectByPid(Long pid);
}
