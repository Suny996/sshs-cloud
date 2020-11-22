package com.sshs.cloud.product.controller;

import com.sshs.cloud.product.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
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
@RequestMapping("/product")
@RefreshScope
public class ProductController {

    @Value("${product.mock}")
    private String mockUrl;
    @Resource
    Environment environment;

    /**
     * 根据商品ID获取商品信息
     */
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") String id) {
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject(mockUrl + "/product/" + id, Product.class);
        product.setNode(environment.getProperty("local.server.port"));

        return product;
    }

    /**
     * 获取商品列表信息
     */
    @GetMapping()
    public List<Product> getProductList() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(mockUrl + "/product", List.class);
    }

    /**
     * 获取商品列表信息
     */
    @GetMapping("/order/{id}")
    public List<Product> getOrderProductList(@PathVariable("id") String id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(mockUrl + "/product", List.class);
    }
}