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
    @Autowired
    @Qualifier("appServiceImpl")
    private AppServiceImpl appService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,Object> login(@RequestBody User user){
        System.out.println(user);

        return appService.login(user.getUsername(), user.getPassword());
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public void query(@RequestParam("id")String id){
        System.out.println("id"+id);
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Map<String,Object> register(){
        return null;
    }
}
