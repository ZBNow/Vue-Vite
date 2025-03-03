package com.example.demo.mapper;

import com.example.demo.dao.TableProps;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TablePropsMapper {
    List<TableProps> getTableProps(String tableName);//获取表格有哪些列
}
