package com.ljh.mybatis_books.mapper;

import com.ljh.mybatis_books.domain.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> findAll();

    Book findById (long id);

    void insert (Book book);

    void update (Book book);

    void delete (Long id);
}
