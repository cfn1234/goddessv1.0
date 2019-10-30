package com.goddess.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * com.goddess.controller
 *
 * @author caofengnian
 * @Date 2019-10-24
 */
@RestController
@RequestMapping("index")
public class IndexController {

    @GetMapping("get")
    public String index(HttpServletRequest request,String a) {

        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {

            System.out.println( c.getValue());
        }
        request.getSession().setAttribute("cc",a);
        return "1";
    }
    @GetMapping("getSession")
    public String getSession(HttpServletRequest request){

        return (String) request.getSession().getAttribute("cc");
    }
}