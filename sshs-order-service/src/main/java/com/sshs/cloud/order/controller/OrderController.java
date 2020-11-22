package com.sshs.cloud.order.controller;

import com.sshs.cloud.order.model.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sunyonggang
 */
@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {

    @Value("${order.mock}")
    private String mockUrl;
    @Resource
    ProductClient productClient;

    @Resource
    RestTemplate restTemplate;

    /**
     * 根据商品ID获取商品信息
     */
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable("id") String id) {
        Order order = restTemplate.getForObject(mockUrl + "/order/" + id, Order.class);
        order.setProducts(productClient.getOrderProductList(id));
        return order;
    }

    /**
     * 获取商品列表信息
     */
    @GetMapping()
    public List<Order> getOrderList() {
        return restTemplate.getForObject(mockUrl + "/order", List.class);
    }
}