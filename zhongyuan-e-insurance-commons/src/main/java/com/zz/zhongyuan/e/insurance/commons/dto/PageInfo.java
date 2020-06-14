package com.zz.zhongyuan.e.insurance.commons.dto;

import com.zz.zhongyuan.e.insurance.commons.persistence.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: PageInfo
 * Description: <br/>
 * date: 2020/2/2 23:05
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
public class PageInfo<T extends BaseEntity> implements Serializable {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<T> data;
    private String error;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
