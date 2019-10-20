# shiro_demo
springboot整合shiro的demo  

## 说明
本仓库仅仅是测试springboot整合shiro框架，dao层没有真正访问数据库，
而是模拟从数据库中取数据，所以不需要什么环境配置。
````
package com.ddu.shiro_demo.dao;

import ...

@Component
public class PermissionDao {

    static List<Permission> db;

    static {
        db = new ArrayList<>();
        db.add(new Permission("p001","add"));
        db.add(new Permission("p002","delete"));
        db.add(new Permission("p003","update"));
        db.add(new Permission("p004","select"));
    }
    ...
}
````

为了更好的模拟权限管理，我设置了三个用户，两个角色：
- 用户：user01，user02，user03
- 角色：admin，guest  
- 权限：add，delete，update，select
- 对应关系  
|用户       |角色       |权限                         
|user01     |admin     |add,delete,update,select  
|user02     |guest     |add,select   
|user03     |guest     |add,select  

还需要说明的是``controller``包下的接口，该包下有三个类：
- `BookController`   
给类下有四类接口，分别是增加，删除，修改，查询，权限控制主要也是针对这些接口，
我们需要让上面定义的三个用户**完成登录**后，依据**自己的权限**来进行访问。
- `LoginController`  
该类下有登录接口，所有人都能访问该接口进行登录，如果没有登录，
不允许访问``BookController``类下所有的接口
- `TestController`  
该类下有一个测试接口，用于测试项目是否真正，所有人都可访问  

我们这个项目端口使用的是`8081`，根目录为`/sd`，url样例为：
``http://localhost:8081/sd/test``，如果返回``10000``（如下所示），
不要紧张，这正常的，因为代码还有很多问题，需要你自行解决。
````
{
    "code": 10000,
    "success": false,
    "message": "账号或密码错误",
    "data": null
}
````