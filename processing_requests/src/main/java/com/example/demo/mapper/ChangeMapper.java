package com.example.demo.mapper;

import com.example.demo.dao.Question;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChangeMapper {
    void change(Question question);
}
