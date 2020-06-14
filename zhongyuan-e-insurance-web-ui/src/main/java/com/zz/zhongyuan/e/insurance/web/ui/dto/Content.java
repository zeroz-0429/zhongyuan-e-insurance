package com.zz.zhongyuan.e.insurance.web.ui.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: Content
 * Description: <br/>
 * date: 2020/4/17 21:21
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Data
public class Content implements Serializable {
    private Long cid;
    private String title;
    private String titleDesc;
    private String pictrue;
    private String content;
}
