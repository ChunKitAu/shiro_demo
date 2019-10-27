package com.ddu.shiro_demo.controller;

import com.ddu.shiro_demo.utils.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther ChunKit
 * @date 2019/10/24-9:15
 */
@RestController
public class ErrorController {

    @GetMapping("/error")
    public CommonResult error(){
        return CommonResult.failure();
    }

}
