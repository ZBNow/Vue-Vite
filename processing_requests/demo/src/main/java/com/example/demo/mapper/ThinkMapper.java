package com.example.demo.mapper;

import com.example.demo.dao.Option;
import com.example.demo.dao.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//数据库调用接口
@Mapper
public interface ThinkMapper {
    List<Option>selectOptions();
}
