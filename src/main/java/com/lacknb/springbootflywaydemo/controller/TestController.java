package com.lacknb.springbootflywaydemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gitsilence
 * @date 2024-01-06
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring boot ~";
    }

}
