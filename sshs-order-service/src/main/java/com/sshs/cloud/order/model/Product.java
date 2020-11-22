package com.sshs.cloud.order.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Suny
 * @date 2020/11/22
 */
@Data
public class Product extends Entity {
    /**
     * 商品ID
     */
    private Long id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品库存
     */
    private Integer stock;

}
