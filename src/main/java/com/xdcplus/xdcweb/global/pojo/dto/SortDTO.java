package com.xdcplus.xdcweb.global.pojo.dto;

import cn.hutool.core.util.StrUtil;
import com.xdcplus.xdcweb.global.utils.PageableUtils;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 *   排序Dto对象
 * @author Rong.Jia
 * @date 2018/6/20 10:56
 */
@ToString
@EqualsAndHashCode
public class SortDTO implements Serializable {

    private static final long serialVersionUID = -7426543317336625416L;

    /**
     * 排序方式
     */
    private String orderType;

    /**
     * 排序字段
     */
    private String orderField;

    public SortDTO() {
        super();
    }

    public SortDTO(String orderType, String orderField) {
        this.orderType = StrUtil.isBlank(orderType) ? PageableUtils.DEFAULT_ORDER_TYPE : orderType;
        this.orderField = StrUtil.isBlank(orderField) ? PageableUtils.DEFAULT_ORDER_FIELD : orderField;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = StrUtil.isBlank(orderType) ? PageableUtils.DEFAULT_ORDER_TYPE : orderType;
    }

    public String getOrderField() {
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = StrUtil.isBlank(orderField) ? PageableUtils.DEFAULT_ORDER_FIELD : orderField;
    }
}
