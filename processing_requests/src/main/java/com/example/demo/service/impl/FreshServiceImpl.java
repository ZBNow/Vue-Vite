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
        
        int c=lmc.getCurrentPage();
        int s=lmc.getPageSize();
        Map<String,Object>res=new HashMap<>();
        Map<String,Object>data=new HashMap<>();
        if(lmc.getType().equals("think")){//题目首页
            try{
                List<Question>findData;
                if(lmc.getLmc()==null)//无查询条件<-->显示所有题目
                    findData=freshMapper.fresh1(lmc.getPageSize());
                    //显示数量不能大于PageSize(由前端改变)
                else
                    findData=freshMapper.fresh2(lmc);//根据lmc查询
                List<Question>tableData=findData.subList((c-1)*s,min(findData.size(),(c-1)*s+s));
                //c=lmc.getCurrentPage();s=lmc.getPageSize();
                //findData.subList((c-1)*s,min(findData.size(),(c-1)*s+s))实现分页功能
                //截取并返回findData数组中的[(c-1)*s,min(findData.size(),(c-1)*s+s))部分
                //min(findData.size(),(c-1)*s+s)用于处理最后一页显示项不够的情况
                res.put("code",200);
                data.put("total",findData.size());
                data.put("tableData",tableData);
                System.out.println("tableData");
                System.out.println(tableData);
                res.put("data",data);
            }catch (Exception e){
                System.out.println(e);
            }
        } else if (lmc.getType().equals("jobs")) {//在我的作业页面
            try{
                List<Jobs>findData;
                //System.out.println(lmc.getId());
                if(lmc.getStates().get(0).isEmpty() && lmc.getId()==null){
                    findData=jobsMapper.fresh1();
                    //System.out.println("lmc.getPageSize():"+lmc.getPageSize());

                }

                else {
                    //assert lmc.getStates() != null;
                    /*断言（assert)是一种用于测试代码中假设的工具。
                        通过在代码中插入断言，可以在开发和测试阶段捕获潜在的错误。
                        assert condition;condition是一个布尔表达式，假定在程序执行时为真。
                        如果条件为假，JVM会抛出AssertionError，程序会立即停止。
                    */
                    //System.out.println("'"+String.join("','", lmc.getStates())+"'");
                    findData=jobsMapper.fresh2("'"+String.join("','", lmc.getStates())+"'");
                    /*String.join方法用于将多个字符串连接成一个新的字符串。
                        这个方法接受一个分隔符和一个可变数量的字符序列作为参数。如果任何元素为null，它将被视为字符串"null"。
                        示例:String message = String.join("-", "This", "is", "a", "String");
                        返回的消息是: "This-is-a-String"
                    */
                    //此处用来特殊处理'全部'对应状态是一个多项数组的情况
                    //[通过]-->'通过',[通过,未通过,编译错误,待提交]-->'通过','未通过','编译错误','待提交'
                }
                List<Jobs>tableData=findData.subList((c-1)*s,min(findData.size(),(c-1)*s+s));
                List<TableProps> tableProps=tablePropsMapper.getTableProps("jobs");
                //System.out.println(tableProps);
                res.put("code",200);
                data.put("total",findData.size());
                data.put("tableData",tableData);
                data.put("tableProp",tableProps);
                res.put("data",data);
            }catch (Exception e){
                System.out.println(e);
            }
        }
        //System.out.println(res);
        return res;
    }
}
