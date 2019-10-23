package com.ddu.shiro_demo.controller;

import com.ddu.shiro_demo.utils.CommonResult;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiresAuthentication
@RequestMapping("/book")
public class BookController {
    /**
     * 查询所有书本记录
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    @RequiresPermissions("select")
    @GetMapping("/list")
    public CommonResult list(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize) {
        return CommonResult.success();
    }

    /**
     * 查询单条记录
     *
     * @param id
     * @return
     */
    @GetMapping
    @RequiresPermissions("select")
    public CommonResult getOne(@RequestParam("id") String id) {
        return CommonResult.success();
    }

    /**
     * 添加书本记录
     *
     * @param name
     * @return
     */
    @PostMapping
    @RequiresPermissions("add")
    public CommonResult register(@RequestParam("name") String name) {
        return CommonResult.success();
    }

    /**
     * 更新
     *
     * @param id
     * @param name
     * @return
     */
    @RequiresPermissions("update")
    @PutMapping
    public CommonResult amend(@RequestParam("id") String id, @RequestParam("name") String name) {
        return CommonResult.success();
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequiresPermissions("delete")
    @DeleteMapping
    public CommonResult delete(@RequestParam("id") String id) {
        return CommonResult.success();
    }
}
