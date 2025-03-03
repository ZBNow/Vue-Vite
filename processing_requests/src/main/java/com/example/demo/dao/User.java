package com.example.demo.dao;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//提升访问效率
@Data//来自依赖lombok，自动补全set(),get()，toString()函数
public class User {
    @JsonIgnore//序列化（转成json）时忽略
    private long uid;
    //使用@JsonAlise还可以匹配username
    @JsonAlias(value = {"username","USERNAME","UserName"})
    private String username;
    //使用@JsonProperty不可以匹配password
    //@JsonProperty("Pwd")
    private String password;
    @JsonProperty("enable")//用enable对应enable作为json的键
    private boolean enable;
    private boolean locked;
    private List<Role> roles;
}