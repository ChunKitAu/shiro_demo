package com.ddu.shiro_demo.controller;

import com.ddu.shiro_demo.utils.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test")
    public CommonResult test() {
        return CommonResult.success().setData("mdzz");
    }

}
