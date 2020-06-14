package com.zz.zhongyuan.e.insurance.web.admin.users.service.impl;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.validator.BeanValidator;
import com.zz.zhongyuan.e.insurance.domain.ContentCategory;
import com.zz.zhongyuan.e.insurance.web.admin.users.dao.ContentCategoryDao;
import com.zz.zhongyuan.e.insurance.web.admin.users.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * ClassName: ContentCategoryServiceImpl
 * Description: <br/>
 * date: 2020/3/22 23:25
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Autowired
    private ContentCategoryDao contentCategoryDao;

    @Override
    public List<ContentCategory> selectAll() {
        return contentCategoryDao.selectAll();
    }

    @Override
    public BaseResult save(ContentCategory contentCategory) {
        String validator= BeanValidator.validator(contentCategory);
        if (validator!=null){
            return BaseResult.fail(validator);
        }
        else{
            ContentCategory parent=contentCategory.getParent();
            //如果没有选择父级节点则默认设置为根目录
            if (parent==null || parent.getCcid()==null){
                parent.setCcid(0L);
            }
            contentCategory.setUpdated(new Date());
            //新增
            if (contentCategory.getCcid()==null){
                contentCategory.setCreated(new Date());
                contentCategory.setIsParent(false);
                //判断当前新增的有没有父级节点
                if (parent.getCcid()!=0L){
                    ContentCategory currentCategoryParent=getById(parent.getCcid());
                    if (currentCategoryParent!=null){
                        currentCategoryParent.setIsParent(true);
                        update(currentCategoryParent);
                    }
                }
                //父级节点为0
                else {
                    //根目录一定是父级目录
                    contentCategory.setIsParent(true);
                }
                contentCategoryDao.insert(contentCategory);
            }
            //修改
            else {
                update(contentCategory);
            }
            return BaseResult.success("保存分类信息成功");
        }
    }

    @Override
    public void delete(Long ccid) {
         contentCategoryDao.delete(ccid);
    }

    @Override
    public ContentCategory getById(Long ccid) {
        return contentCategoryDao.getById(ccid);
    }

    @Override
    public void update(ContentCategory contentCategory) {
        contentCategoryDao.update(contentCategory);
    }

    @Override
    public List<ContentCategory> selectByPid(Long pid) {
        return contentCategoryDao.selectByPid(pid);
    }
}
