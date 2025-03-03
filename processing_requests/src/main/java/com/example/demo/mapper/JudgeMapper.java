package com.example.demo.mapper;

import com.example.demo.dao.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface JudgeMapper {
    List<Question> judgeId(Question question);

}
