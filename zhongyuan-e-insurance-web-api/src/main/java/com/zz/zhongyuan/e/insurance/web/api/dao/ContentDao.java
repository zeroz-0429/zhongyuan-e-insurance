package com.zz.zhongyuan.e.insurance.web.api.dao;

import com.zz.zhongyuan.e.insurance.domain.Content;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: ContentDao
 * Description: <br/>
 * date: 2020/4/17 13:32
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Repository
public interface ContentDao {
    /**
     * 根据类别 ID 查询内容列表
     * @param content
     * @return
     */
    List<Content> selectByCategoryId(Content content);
}
