package com.example.demo.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
@Data
public class Question {
    private String type;//类型add/change
    private Integer id;
    @JsonProperty("LMC")
    private String LMC;
    private String title;
    private String pdfString;
}
