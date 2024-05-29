package com.example.other.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024-05-28
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentInfo {

    private int id;

    private String name;

    private int age;
}

