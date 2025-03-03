package com.example.demo.dao;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class Question {
    private Integer id;
    private String LMC;
    private String title;
    private String pdfString;
}
