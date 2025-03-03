package com.example.demo.dao;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class TableProps {
    private Integer id;
    private String tableName;
    private String prop;
    private String label;
    private Integer width;
}
