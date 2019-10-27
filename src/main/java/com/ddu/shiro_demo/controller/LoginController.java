package com.ddu.shiro_demo.controller;

import com.ddu.shiro_demo.utils.CommonResult;
import com.ddu.shiro_demo.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class LoginController {

    @PostMapping("/login")
    public CommonResult login(@RequestParam("username") String username,
                              @RequestParam("password") String password) {
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();

        //MD5盐值加密后的密码
        String md5Password = new SimpleHash("MD5", password, ByteSource.Util.bytes(username), 1024).toString();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                username,
                md5Password
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
//            subject.checkRole("admin");
//            subject.checkPermissions("select", "add");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return CommonResult.failure("账号或密码错误");
        } catch (AuthorizationException e) {
            e.printStackTrace();
            return CommonResult.failure("没有权限");
        }
        return CommonResult.success();
    }


    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * @return
     */
    @RequestMapping(value = "/logout")
    public CommonResult logout() {
        Subject lvSubject=SecurityUtils.getSubject();
        lvSubject.logout();
        return CommonResult.success().setMessage("退出成功");
    }

    @RequestMapping(value = "/login")
    public CommonResult unauth() {
        return CommonResult.failure().setCode(401).setMessage("未登录");
    }


    //注解验角色和权限
//    @RequiresRoles("admin")
//    @RequiresPermissions("add")
    @RequestMapping("/index")
    public String index() {
        return "index!";
    }
}
