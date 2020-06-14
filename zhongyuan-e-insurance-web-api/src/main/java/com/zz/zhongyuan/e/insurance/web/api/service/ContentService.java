package com.zz.zhongyuan.e.insurance.web.api.service;

import com.zz.zhongyuan.e.insurance.domain.Content;

import java.util.List;

/**
 * ClassName: ContentService
 * Description: <br/>
 * date: 2020/4/17 13:33
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public interface ContentService {
    /**
     * 根据类别 ID 查询内容列表
     * @param categoryId
     * @return
     */
    List<Content> selectByCategoryId(Long categoryId);
}
