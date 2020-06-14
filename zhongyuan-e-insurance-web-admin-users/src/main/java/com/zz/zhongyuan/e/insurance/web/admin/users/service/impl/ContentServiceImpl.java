package com.zz.zhongyuan.e.insurance.web.admin.users.service.impl;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.dto.PageInfo;
import com.zz.zhongyuan.e.insurance.commons.validator.BeanValidator;
import com.zz.zhongyuan.e.insurance.domain.Content;
import com.zz.zhongyuan.e.insurance.web.admin.users.dao.ContentDao;
import com.zz.zhongyuan.e.insurance.web.admin.users.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: ContentServiceImpl
 * Description: <br/>
 * date: 2020/3/22 23:26
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
    public List<Content> selectAll() {
        return contentDao.selectAll();
    }

    @Override
    public BaseResult save(Content content) {
        String validator = BeanValidator.validator(content);
        //验证不通过
        if (validator!=null){
            return BaseResult.fail(validator);
        }
        //验证通过
        else {
            content.setUpdated(new Date());
            //新增
            if (content.getCid()==null){
                content.setCreated(new Date());
                contentDao.insert(content);
            }
            //编辑
            else {
                update(content);
            }
            return BaseResult.success("保存内容信息成功");
        }
    }

    @Override
    public void delete(Long cid) {
        contentDao.delete(cid);
    }

    @Override
    public Content getById(Long cid) {
        return contentDao.getById(cid);
    }

    @Override
    public void update(Content content) {
        contentDao.update(content);
    }

    @Override
    public void deleteMulti(String[] cids) {
        contentDao.deleteMulti(cids);
    }

    @Override
    public PageInfo<Content> page(int start, int length, int draw, Content content) {
        int count = count(content);

        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", content);

        PageInfo<Content> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(contentDao.page(params));

        return pageInfo;
    }

    @Override
    public int count(Content content) {
        return contentDao.count(content);
    }
}
