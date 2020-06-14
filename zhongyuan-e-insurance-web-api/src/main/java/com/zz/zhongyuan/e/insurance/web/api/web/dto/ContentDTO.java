package com.zz.zhongyuan.e.insurance.web.api.web.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: ContentDTO
 * Description: <br/>
 * date: 2020/4/17 13:35
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Data
public class ContentDTO implements Serializable {
    private Long cid;
    private String title;
    private String titleDesc;
    private String pictrue;
    private String content;
}
