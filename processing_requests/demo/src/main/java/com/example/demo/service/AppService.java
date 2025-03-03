package com.example.demo.service;

import java.util.Map;
//service层，用来供控制层调用，调用mapper层
public interface AppService {
    Map<String, Object> login(String username, String password);
}
