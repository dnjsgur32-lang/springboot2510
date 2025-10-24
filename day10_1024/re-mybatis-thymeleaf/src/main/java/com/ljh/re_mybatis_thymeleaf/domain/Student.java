package com.ljh.re_mybatis_thymeleaf.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Student {

    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
