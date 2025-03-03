package com.example.demo.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
@Data
public class Lmc {
    private String type;//类型think/job
    private Integer currentPage;//当前在第几页
    private Integer pageSize;//一页有几项
    @JsonProperty("LMC")//发给前端时将键名lmc-->LMC，解决前后端命名不同的问题
    private String lmc;//字符串，格式：level-module-chapter
    private List<String> states;
    //状态对应前端states=state==='全部'?['通过','未通过','编译错误','待提交']:[`${state}`];
    private String username;//用户名
    private Integer id;//id
}
