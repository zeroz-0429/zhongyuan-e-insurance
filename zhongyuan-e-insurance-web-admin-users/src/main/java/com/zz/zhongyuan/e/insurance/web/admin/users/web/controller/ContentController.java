package com.zz.zhongyuan.e.insurance.web.admin.users.web.controller;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.commons.dto.PageInfo;
import com.zz.zhongyuan.e.insurance.domain.Content;
import com.zz.zhongyuan.e.insurance.web.admin.users.service.ContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: ContentController
 * Description: <br/>
 * date: 2020/3/22 23:28
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Controller
@RequestMapping(value = "content")
public class ContentController {
    @Autowired
    private ContentService contentService;
    @ModelAttribute
    public Content getTbContent(Long cid){
        //id不为空从数据库获取
        Content content=null;
        if (cid!=null){
            content= contentService.getById(cid);
        }
        else {
            content=new Content();
        }
        return content;
    }

    /**
     * 跳转到内容列表页面
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "content_list";
    }

    /**
     * 跳转到添加内容页面
     * @return
     */
    @RequestMapping(value ="form",method = RequestMethod.GET)
    public String form(){
        return "content_form";
    }

    /**
     * 保存用户信息到内容列表
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(Content content, Model model, RedirectAttributes redirectAttributes,HttpServletRequest request){
        String categoryName=request.getParameter("categoryName");
        if (categoryName.equals("")){
            model.addAttribute("categoryName",BaseResult.fail("父级目录不能为空"));
            return "content_form";
        }
        BaseResult baseResult=contentService.save(content);
        //保存用户信息成功，跳转到用户列表页
        if (baseResult.getStatus()==200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/content/list";
        }
        //失败，跳转到表单页
        else {
            model.addAttribute("baseResult",baseResult);
            return "content_form";
        }
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deleteMul" ,method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult=null;
        if (StringUtils.isNotBlank(ids)){
            String[] idArray=ids.split(",");
            contentService.deleteMulti(idArray);
            baseResult=BaseResult.success("删除内容成功");
        }
        else {
            baseResult=BaseResult.fail("删除内容失败");
        }
        return baseResult;
    }

    /**
     * 删除
     * @param cid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete" ,method = RequestMethod.POST)
    public BaseResult delete(Long cid){
        BaseResult baseResult=null;
        if (cid != null){
            contentService.delete(cid);
            baseResult=BaseResult.success("内容删除成功");
        }
        else {
            baseResult=BaseResult.fail("内容删除失败");
        }
        return baseResult;
    }

    /**
     * 分页
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<Content> page(HttpServletRequest request, Content content){
        String strDraw=request.getParameter("draw");
        String strStart=request.getParameter("start");
        String strLength=request.getParameter("length");

        int draw=strDraw==null ? 0 :Integer.parseInt(strDraw);
        int start=strStart==null ? 0 :Integer.parseInt(strStart);
        int length=strLength==null ? 10 :Integer.parseInt(strLength);

        //封装dataTables需要的结果
        PageInfo<Content> pageInfo=contentService.page(start,length,draw,content);

        return pageInfo;
    }

    /**
     * 显示内容详情
     * @return
     */
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(){
        return "content_detail";
    }
}
