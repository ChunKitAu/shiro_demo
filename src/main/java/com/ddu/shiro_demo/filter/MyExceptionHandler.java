package com.ddu.shiro_demo.filter;

import com.ddu.shiro_demo.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class MyExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public CommonResult ErrorHandler(AuthorizationException e) {
        log.error("没有通过权限验证！", e);
        return CommonResult.failure().setCode(403).setMessage("没有通过权限验证！");
    }

}
