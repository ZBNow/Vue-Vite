package com.example.demo.service.impl;

import ch.qos.logback.core.util.StringUtil;
import com.example.demo.dao.Jobs;
import com.example.demo.dao.Lmc;
import com.example.demo.dao.Question;
import com.example.demo.dao.TableProps;
import com.example.demo.mapper.FreshMapper;
import com.example.demo.mapper.JobsMapper;
import com.example.demo.mapper.TablePropsMapper;
import com.example.demo.service.FreshService;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.min;
import static java.lang.String.join;

@Service
public class FreshServiceImpl implements FreshService {
    @Autowired
    private FreshMapper freshMapper;
    @Autowired
    private JobsMapper jobsMapper;
    @Autowired
    private TablePropsMapper tablePropsMapper;
    @Override
    public Map<String,Object> fresh(Lmc lmc){
        
        int c= lmc.getCurrentPage();
        int s=lmc.getPageSize();
        Map<String,Object>res=new HashMap<>();
        Map<String,Object>data=new HashMap<>();
        if(lmc.getType().equals("think")){
            try{
                List<Question>findData;
                if(lmc.getLmc()==null)findData=freshMapper.fresh1(lmc.getPageSize());
                else findData=freshMapper.fresh2(lmc);
                List<Question>tableData=findData.subList((c-1)*s,min(findData.size(),(c-1)*s+s));
                res.put("code",200);
                data.put("total",findData.size());
                data.put("tableData",tableData);
                res.put("data",data);
            }catch (Exception e){
                System.out.println(e);
            }
        } else if (lmc.getType().equals("jobs")) {
            try{
                List<Jobs>findData;
                if(lmc.getStates()==null&&lmc.getId()==null)findData=jobsMapper.fresh1(lmc.getPageSize());
                else {
                    assert lmc.getStates() != null;
                    System.out.println("'"+String.join("','", lmc.getStates())+"'");
                    findData=jobsMapper.fresh2("'"+String.join("','", lmc.getStates())+"'");
                }
                List<Jobs>tableData=findData.subList((c-1)*s,min(findData.size(),(c-1)*s+s));
                List<TableProps> tableProps=tablePropsMapper.getTableProps("jobs");
                System.out.println(tableProps);
                res.put("code",200);
                data.put("total",findData.size());
                data.put("tableData",tableData);
                data.put("tableProp",tableProps);
                res.put("data",data);
            }catch (Exception e){
                System.out.println(e);
            }
        }
        System.out.println(res);
        return res;
    }
}
