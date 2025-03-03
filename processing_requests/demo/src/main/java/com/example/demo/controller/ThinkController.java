package com.example.demo.controller;

import com.example.demo.dao.Jobs;
import com.example.demo.dao.Lmc;
import com.example.demo.service.impl.FreshServiceImpl;
import com.example.demo.service.impl.ThinkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/lmc")
public class ThinkController {
    @Autowired
    private ThinkServiceImpl thinkService;
    @Autowired
    private FreshServiceImpl freshService;
    @RequestMapping(value = "/options" ,method = RequestMethod.POST)
    public Map<String,Object> thinkHome(){
        return thinkService.getOptions();
    }
    @RequestMapping(value = "/fresh" ,method = RequestMethod.POST)
    public Map<String,Object> fresh(@RequestBody Lmc lmc){
        System.out.println(lmc);
        return freshService.fresh(lmc);
    }

}
