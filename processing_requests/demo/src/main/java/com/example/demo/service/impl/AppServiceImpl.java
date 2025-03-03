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
    @Override
    public Map<String, Object> login(String username, String password) {
        Map<String,Object> res = new HashMap<>();
        List<User>userlist=loginMapper.selectByUserName(username);
        System.out.println(userlist);
        if(userlist.isEmpty()){
            res.put("code",202);
            res.put("msg","用户名不存在");
        }
        boolean f=false;
        for(User user:userlist){
            if(user.getPassword().equals(password)){
                res.put("code",200);
                res.put("msg","用户验证成功");
                f=true;
                break;
            }
        }
        if(!f){
            res.put("code",201);
            res.put("msg","密码错误");
        }else{
            Map<String,Object> data = new HashMap<>();
            data.put("username",username);
            data.put("token","@sjsdfhjfsdjvsdjfjsfsdfgshfk");
            res.put("data",data);
        }
        return res;
    }
}
