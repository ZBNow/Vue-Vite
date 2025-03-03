package com.example.demo.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data//自动添加getter和setter方法
public class User {
    @JsonIgnore//序列化（转成json）时忽略
    private long uid;
    private String username;
    private String password;
    @JsonProperty("enable")//用enable对应enable作为json的键
    private boolean enable;
    private boolean locked;
    private List<Role> roles;
}
