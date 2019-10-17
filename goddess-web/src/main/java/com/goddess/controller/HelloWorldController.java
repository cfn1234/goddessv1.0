package com.goddess.controller;

import com.goddess.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br>
 * 〈功能详细描述〉
 * com.goddess.controller
 *
 * @author caofengnian 2019/3/13 0013 15:32
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
public class HelloWorldController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String index() {
        userService.findByUserName("11");
        return "Hello World";
    }
}
