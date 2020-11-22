package com.sshs.cloud.order.controller;

import com.sshs.cloud.order.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author sunyonggang
 */
@Component
@FeignClient(name = "product-service")
public interface ProductClient {

    /**
     * 根据商品ID获取商品信息
     */
    @GetMapping("/product/{id}")
    Product getProduct(@PathVariable("id") String id);

    /**
     * 获取商品列表信息
     */
    @GetMapping("/product")
    List<Product> getProductList();

    /**
     * 获取商品列表信息
     *
     * @param orderId
     */
    @GetMapping("/product/order/{id}")
    List<Product> getOrderProductList(@PathVariable("id") String orderId);
}