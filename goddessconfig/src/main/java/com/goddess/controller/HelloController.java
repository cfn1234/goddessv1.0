package com.goddess.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.goddess.controller
 *
 * @author caofengnian
 * @Date 2019-11-04
 */
@RestController
public class HelloController {
    @Value("${neo.hello}")
    private String nickName;

    @RequestMapping("/hello")
    public String hello() {
        return "hello " + nickName;
    }

}