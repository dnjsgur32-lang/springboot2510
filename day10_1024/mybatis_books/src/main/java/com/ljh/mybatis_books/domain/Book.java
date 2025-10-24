package com.ljh.mybatis_books.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Book {

    private Long id;
    private String title;
    private String author;
    private Integer price;
    private Integer stock;
    private LocalDateTime createdAt;
}
