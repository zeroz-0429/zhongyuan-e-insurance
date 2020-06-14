package com.zz.zhongyuan.e.insurance.web.api.service.impl;

import com.zz.zhongyuan.e.insurance.domain.Content;
import com.zz.zhongyuan.e.insurance.domain.ContentCategory;
import com.zz.zhongyuan.e.insurance.web.api.dao.ContentDao;
import com.zz.zhongyuan.e.insurance.web.api.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: ContentServiceImpl
 * Description: <br/>
 * date: 2020/4/17 13:34
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentDao contentDao;

    @Override
    public List<Content> selectByCategoryId(Long categoryId) {
        ContentCategory contentCategory = new ContentCategory();
        contentCategory.setCcid(categoryId);
        Content tbContent = new Content();
        tbContent.setContentCategory(contentCategory);
        return contentDao.selectByCategoryId(tbContent);
    }
}
