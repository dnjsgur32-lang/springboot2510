package com.ljh.mybatis_books.service;

import com.ljh.mybatis_books.domain.Book;
import com.ljh.mybatis_books.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {

    private final BookMapper bookMapper;

    public List<Book> getAllBooks () {
        return bookMapper.findAll();
    }

    public Book getBook (long id) {
        return bookMapper.findById(id);
    }

    @Transactional
    public void createBook (Book book) {
        bookMapper.insert(book);
    }

    @Transactional
    public void updateBook (Book book) {
        bookMapper.update(book);
    }

    public void deleteBook (Long id) {
        bookMapper.delete(id);
    }
}
