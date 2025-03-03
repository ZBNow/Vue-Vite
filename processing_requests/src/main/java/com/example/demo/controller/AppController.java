package com.example.demo.controller;

import com.example.demo.dao.User;
import com.example.demo.service.impl.AppServiceImpl;
import com.example.demo.service.impl.ThinkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
//Controller层，用于接受客户端请求，调用服务
@RestController
public class AppController {
    @Autowired//它可以对类成员变量、方法及构造函数进行标注，让 spring 完成 bean 自动装配的工作
    @Qualifier("appServiceImpl")  //@Qualifier???
    private AppServiceImpl appService;
    //@RequestMapping：用于将任意HTTP请求映射到控制器方法上
    //value：请求路由，对应前端axios文件中的路径
    //method：指定请求方式，如果没有指定请求方式，将接收
    //  GET、POST、HEAD、OPTIONS、PUT、PATCH、DELETE、TRACE、CONNECT所有的HTTP请求方式
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,Object> login(@RequestBody User user){
        //@RequestBody用来将前端接收json字符串中的数据转换为Java类

        //System.out.println(user);
        return appService.login(user.getUsername(), user.getPassword());
    }
    //登录，通过POST请求从前端申请数据然后包装成User类，再执行AppServiceImpl接口实例的登陆函数
    //
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Map<String,Object> register(){
        return null;
    }
    //注册，暂未完善，敬请期待

}
