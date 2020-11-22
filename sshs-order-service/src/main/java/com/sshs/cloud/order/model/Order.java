package com.sshs.cloud.order.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Suny
 * @date 2020/11/22
 */
@Data
public class Order {
    /**
     * 订单ID
     */
    private Long id;
    /**
     * 商品信息
     */
    private List<Product> products;

    /**
     * 订单金额
     */
    private BigDecimal price;

    /**
     * 下单时间
     */
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 订单状态
     */
    private Integer status;
}
