package com.zz.zhongyuan.e.insurance.web.admin.users.service;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.domain.ContentCategory;
import java.util.List;

/**
 * ClassName: ContentCategoryService
 * Description: <br/>
 * date: 2020/3/22 23:25
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public interface ContentCategoryService {
    /**
     * 查询所有信息
     * @return
     */
    public List<ContentCategory> selectAll();

    /**
     * 新增
     * @param contentCategory
     */
    public BaseResult save(ContentCategory contentCategory);

    /**
     * 删除
     * @param ccid
     */
    public void delete(Long ccid);

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
