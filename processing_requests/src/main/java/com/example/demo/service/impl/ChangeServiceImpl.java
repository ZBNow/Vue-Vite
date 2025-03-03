package com.example.demo.service.impl;

import com.example.demo.dao.Option;
import com.example.demo.dao.Question;
import com.example.demo.mapper.AddMapper;
import com.example.demo.mapper.ChangeMapper;
import com.example.demo.mapper.DeleteMapper;
import com.example.demo.mapper.JudgeMapper;
import com.example.demo.service.ChangeService;
import org.apache.tomcat.Jar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ChangeServiceImpl implements ChangeService {
    @Autowired
    private AddMapper addMapper;
    @Autowired
    private ChangeMapper changeMapper;
    @Autowired
    private JudgeMapper judgeMapper;
    @Autowired
    private DeleteMapper deleteMapper;

    @Override
    public Map<String,Object> changeQuestion(Question question){
        if(Objects.equals(question.getType(), "add")){
            List<Question> isIdExist=judgeMapper.judgeId(question);
            Map<String, Object> res = new HashMap<String, Object>();

            System.out.println("isIdExist:"+isIdExist);
            if(!isIdExist.isEmpty()){
                res.put("code",0);
                res.put("msg","id已存在");
                res.put("data",isIdExist);
            }else if(!question.getLMC().startsWith("L")){
                res.put("code",0);
                res.put("msg","LMC不合法");
            }else{
                addMapper.add(question);
                res.put("code",200);
                res.put("msg","添加成功");
            }
            System.out.println(res);
            return res;

        }
        else if(Objects.equals(question.getType(), "change")){
            Map<String, Object> res = new HashMap<String, Object>();
            if(!question.getLMC().startsWith("L")){
                res.put("code",0);
                res.put("msg","LMC不合法");
            }else{
                changeMapper.change(question);
                res.put("code",200);
                res.put("msg","修改成功");
            }
            return res;
        }else if(Objects.equals(question.getType(), "delete")){
            System.out.println("delete:");
            deleteMapper.delete(question);
            Map<String, Object> res = new HashMap<String, Object>();
            res.put("code",200);
            res.put("msg","删除成功");
            return res;
        }
        return null;
    }
}
