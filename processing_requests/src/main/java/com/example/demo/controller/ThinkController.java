package com.example.demo.controller;

import com.example.demo.dao.Jobs;
import com.example.demo.dao.Lmc;
import com.example.demo.dao.Question;
import com.example.demo.service.ChangeService;
import com.example.demo.service.impl.ChangeServiceImpl;
import com.example.demo.service.impl.FreshServiceImpl;
import com.example.demo.service.impl.ThinkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/lmc")
public class ThinkController {
    @Autowired
    private ThinkServiceImpl thinkService;
    @Autowired
    private FreshServiceImpl freshService;
    @Autowired
    private ChangeServiceImpl changeService;
    //thinkHome()将题目层次从数据库中提取传回前端放入下拉列表


    @RequestMapping(value = "/options" ,method = RequestMethod.POST)
    public Map<String,Object> thinkHome(){

        return thinkService.getOptions();
    }

    //根据前端选择的层次形成lmc串传入后端，后端根据lmc串搜索数据库给出题目列表返回前端
    @RequestMapping(value = "/fresh" ,method = RequestMethod.POST)
    public Map<String,Object> fresh(@RequestBody Lmc lmc){
        //System.out.println(lmc);
        return freshService.fresh(lmc);
    }
    ////////
    @RequestMapping(value = "/change",method = RequestMethod.POST)
    public Map<String,Object> changeQuestion(@RequestBody Question question){
        //System.out.println("question");
        //System.out.println(question);
        return changeService.changeQuestion(question);
    }
}
