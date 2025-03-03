package com.example.demo.dao;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
public class Option {
    private String label;
    private String value;
    private List<Option> children;
}
