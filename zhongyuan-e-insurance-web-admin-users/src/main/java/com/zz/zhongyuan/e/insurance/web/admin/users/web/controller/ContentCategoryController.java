package com.zz.zhongyuan.e.insurance.web.admin.users.web.controller;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.domain.ContentCategory;
import com.zz.zhongyuan.e.insurance.web.admin.users.service.ContentCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ContentCategoryController
 * Description: <br/>
 * date: 2020/3/22 23:27
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
@RequestMapping(value = "content/category")
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @ModelAttribute
    public ContentCategory getTbContentCategory(Long ccid){
        //id不为空从数据库获取
        ContentCategory contentCategory=null;
        if (ccid!=null){
            contentCategory= contentCategoryService.getById(ccid);
        }
        else {
            contentCategory=new ContentCategory();
        }
        return contentCategory;
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        List<ContentCategory> targetList=new ArrayList<>();
        List<ContentCategory> sourceList = contentCategoryService.selectAll();
        //排序
        sortList(sourceList,targetList,0L);
        model.addAttribute("contentCategories",targetList);
        return "content_category_list";
    }
    /**
     * 删除
     *
     * @param ccid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(Long ccid) {
        BaseResult baseResult=null;
        if (ccid != null){
            contentCategoryService.delete(ccid);
            baseResult=BaseResult.success("内容删除成功");
        }
        else {
            baseResult=BaseResult.fail("内容删除失败");
        }
        return baseResult;
    }

    /**
     * 跳转到添加分类页面
     * @return
     */
    @RequestMapping(value ="form",method = RequestMethod.GET)
    public String form(ContentCategory contentCategory){
        return "content_category_form";
    }

    /**
     * 保存
     * @param contentCategory
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(ContentCategory contentCategory, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult=contentCategoryService.save(contentCategory);
        if (baseResult.getStatus()==200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/content/category/list";
        }
        else {
            model.addAttribute("baseResult",baseResult);
            return form(contentCategory);
        }
    }

    /**
     * 树形结构
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/tree/data" ,method = RequestMethod.POST)
    public List<ContentCategory> treeData(Long ccid){
        if (ccid==null){
            ccid=0L;
        }
        return contentCategoryService.selectByPid(ccid);
    }

    /**
     * 排序
     *
     * @param sourceList 数据源集合
     * @param targetList 排序后的集合
     * @param parentId   父节点的 ID
     */
    protected void sortList(List<ContentCategory> sourceList, List<ContentCategory> targetList, Long parentId) {
        for (ContentCategory sourceEntity : sourceList) {
            if (sourceEntity.getParent().getCcid().equals(parentId)) {
                targetList.add(sourceEntity);

                // 判断有没有子节点，如果有则继续追加
                if (sourceEntity.getIsParent()) {
                    for (ContentCategory currentEntity : sourceList) {
                        if (currentEntity.getParent().getCcid().equals(sourceEntity.getCcid())) {
                            sortList(sourceList, targetList, sourceEntity.getCcid());
                            break;
                        }
                    }
                }
            }
        }
    }
}
