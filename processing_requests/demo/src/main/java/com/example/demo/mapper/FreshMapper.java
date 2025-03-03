package com.example.demo.mapper;

import com.example.demo.dao.Lmc;
import com.example.demo.dao.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FreshMapper {
    List<Question> fresh1(Integer id);
    List<Question> fresh2(Lmc lmc);
}
