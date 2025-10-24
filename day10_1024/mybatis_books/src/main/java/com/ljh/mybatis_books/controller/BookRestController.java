package com.ljh.mybatis_books.controller;

import com.ljh.mybatis_books.domain.Book;
import com.ljh.mybatis_books.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
@RequiredArgsConstructor
public class BookRestController {
    private final BookService bookService;

    //    전체 조회 : http://localhost:8082/api/books
    @GetMapping
    public List<Book> list () {
        return bookService.getAllBooks();
    }

    //    단건 조회 :
    @GetMapping("/{id}")
    public ResponseEntity<Book> detail (@PathVariable long id) {
        Book book = bookService.getBook(id);
        return ResponseEntity.ok(book);
    }

    //    등록 : 도서 추가 POST
    @PostMapping
    public ResponseEntity<Book> create (@RequestBody Book book) {
        bookService.createBook(book);
        return ResponseEntity.ok(book);
    }

    //    수정 : 정보 수정 PUT
    @PutMapping("/{id}")
    public ResponseEntity<Book> update (@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        bookService.updateBook(book);

        return ResponseEntity.ok(book);
    }

    //    삭제 : 정보 삭제 DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }


}
