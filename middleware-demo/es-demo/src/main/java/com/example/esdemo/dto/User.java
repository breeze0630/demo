package com.example.esdemo.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@Document(indexName = "user")
public class User implements Serializable {

    private Integer id;

    private String name;

    private String adress;

    private String education;

    private String english_name;

    private String phone_number;
    private Double money;
    private Integer population;

    private String job;

    private LocalDateTime datetime;

}
