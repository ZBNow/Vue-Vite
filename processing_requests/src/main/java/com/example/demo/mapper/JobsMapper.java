package com.example.demo.mapper;

import com.example.demo.dao.Jobs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface JobsMapper {
    List<Jobs> fresh1();
    List<Jobs> fresh2(String state);
}
