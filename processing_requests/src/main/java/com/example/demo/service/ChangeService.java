package com.example.demo.service;

import com.example.demo.dao.Question;

import java.util.Map;

public interface ChangeService {
    public Map<String,Object> changeQuestion(Question question);
}
