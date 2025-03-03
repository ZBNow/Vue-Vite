package com.example.demo.service.impl;

import com.example.demo.dao.Option;
import com.example.demo.mapper.ThinkMapper;
import com.example.demo.service.ThinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ThinkServiceImpl implements ThinkService {
    @Autowired
    private ThinkMapper thinkMapper;
    @Override
    public Map<String, Object> getOptions(){
        List<Option>options=thinkMapper.selectOptions();
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("options", options);
        System.out.println(data);
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("data", data);
        res.put("code",200);
        res.put("msg","获取选择器数组成功");
        return res;
    };
}
