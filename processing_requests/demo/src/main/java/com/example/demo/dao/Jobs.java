package com.example.demo.dao;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class Jobs {
    private String runId;
    private String username;
    private String id;
    private String state;
    private String language;
    private String size;
    private String time;
    private String programString;
}
