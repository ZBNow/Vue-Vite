package com.example.demo.service.impl;

import com.example.demo.dao.User;
import com.example.demo.mapper.LoginMapper;
import com.example.demo.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppServiceImpl implements AppService {
    @Autowired
    private LoginMapper loginMapper;
    @Override//实现接口，需要重写其所有抽象函数
    public Map<String, Object> login(String username, String password) {
        Map<String,Object> res = new HashMap<>();
        List<User>userlist=loginMapper.selectByUserName(username);
        //将数据库中用户名符合条件的用户记录存入userList数组
        //System.out.println(userlist);
        if(userlist.isEmpty()){
            res.put("code",202);//前后端协商好即可
            res.put("msg","用户名不存在");
        }
        boolean isfind=false;//bool值记录是否找到密码相同的用户
        //下述循环用于可以重用户名的系统，兼容不可以重用户名的系统
        for(User user:userlist){
            if(user.getPassword().equals(password)){//密码相同，登陆成功
                res.put("code",200);
                res.put("msg","用户验证成功");
                isfind=true;//标记找到
                break;//小小提高查找效率
            }
        }
        if(!isfind){//找遍数组，未匹配
            res.put("code",201);
            res.put("msg","密码错误");
        }else{//登录
            Map<String,Object> data = new HashMap<>();
            data.put("username",username);
            data.put("token","@sjsdfhjfsdjvsdjfjsfsdfgshfk");//前后端协商好即可
            res.put("data",data);
        }
        return res;//将数据传回前端前端
    }
}
