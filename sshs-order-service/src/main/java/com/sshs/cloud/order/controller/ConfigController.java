package com.sshs.cloud.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sunyonggang
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${order.testName:xxxs}")
    private String testName;
    @Resource
    protected Environment environment;


    /**
     * http://localhost:8080/config/get
     */
    @GetMapping("/{parameter}")
    public String get(@PathVariable("parameter") String parameter) {
        return testName + ">" + parameter + ":" + environment.getProperty(parameter, String.class);
    }
}