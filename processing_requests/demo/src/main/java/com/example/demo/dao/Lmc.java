package com.example.demo.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
@Data
public class Lmc {
    private String type;
    private Integer currentPage;
    private Integer pageSize;
    @JsonProperty("LMC")
    private String lmc;
    private List<String> states;
    private String username;
    private String id;
}
