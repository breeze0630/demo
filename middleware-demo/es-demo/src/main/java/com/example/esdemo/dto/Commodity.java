package com.example.esdemo.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Data
@Document(indexName = "commodity")
public class Commodity implements Serializable {

    @Id
    private String skuId;
    private String name;
    private String category;
    private Integer price;
    private String brand;
    private int stock;
}
