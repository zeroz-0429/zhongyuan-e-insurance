package com.zz.zhongyuan.e.insurance.web.api.web.controller;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.domain.Content;
import com.zz.zhongyuan.e.insurance.web.api.service.ContentService;
import com.zz.zhongyuan.e.insurance.web.api.web.dto.ContentDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ContentController
 * Description: <br/>
 * date: 2020/4/17 13:34
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@RestController
@RequestMapping(value = "/api/content")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @ModelAttribute
    public Content getTbContent(Long ccid) {
        Content content = null;

        if (ccid == null) {
            content = new Content();
        }
        return content;
    }

    /**
     * 幻灯片接口
     * @return
     */
    @RequestMapping(value = "ppt", method = RequestMethod.GET)
    public BaseResult findPPT() {
        List<ContentDTO> contentDTOS = null;
        List<Content> contents = contentService.selectByCategoryId(3L);
        if (contents != null && contents.size() > 0) {
            contentDTOS = new ArrayList<>();
            for (Content content : contents) {
                ContentDTO dto = new ContentDTO();
                BeanUtils.copyProperties(content, dto);
                contentDTOS.add(dto);
            }
        }
        return BaseResult.success("成功", contentDTOS);
    }

    /**
     * 公司信息接口
     * @return
     */
    @RequestMapping(value = "company_info", method = RequestMethod.GET)
    public BaseResult findCompanyInfo() {
        List<ContentDTO> contentDTOS = null;
        List<Content> contents = contentService.selectByCategoryId(5L);
        if (contents != null && contents.size() > 0) {
            contentDTOS = new ArrayList<>();
            for (Content content : contents) {
                ContentDTO dto = new ContentDTO();
                BeanUtils.copyProperties(content, dto);
                contentDTOS.add(dto);
            }
        }
        return BaseResult.success("成功", contentDTOS);
    }

    /**
     * 公司发展接口
     * @return
     */
    @RequestMapping(value = "company_dev", method = RequestMethod.GET)
    public BaseResult findCompanyDev() {
        List<ContentDTO> contentDTOS = null;
        List<Content> contents = contentService.selectByCategoryId(6L);
        if (contents != null && contents.size() > 0) {
            contentDTOS = new ArrayList<>();
            for (Content content : contents) {
                ContentDTO dto = new ContentDTO();
                BeanUtils.copyProperties(content, dto);
                contentDTOS.add(dto);
            }
        }
        return BaseResult.success("成功", contentDTOS);
    }

    /**
     * 投保流程接口
     * @return
     */
    @RequestMapping(value = "introduce", method = RequestMethod.GET)
    public BaseResult findIntroduce() {
        List<ContentDTO> contentDTOS = null;
        List<Content> contents = contentService.selectByCategoryId(7L);
        if (contents != null && contents.size() > 0) {
            contentDTOS = new ArrayList<>();
            for (Content content : contents) {
                ContentDTO dto = new ContentDTO();
                BeanUtils.copyProperties(content, dto);
                contentDTOS.add(dto);
            }
        }
        return BaseResult.success("成功", contentDTOS);
    }

}
