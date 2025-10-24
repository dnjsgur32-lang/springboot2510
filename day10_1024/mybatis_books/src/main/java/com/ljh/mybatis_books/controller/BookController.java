package com.ljh.mybatis_books.controller;

import com.ljh.mybatis_books.domain.Book;
import com.ljh.mybatis_books.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

//    LIST : 전체 목록
    @GetMapping
    public String list (Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "book/list";
    }
//    FORM 수정용 : 단건 정보 출력
    @GetMapping("/{id}/edit")
    public String updateForm (@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBook(id));
        return "book/form";
    }

    @GetMapping("/new")
    public String createForm (Model model) {
        model.addAttribute("book", new Book());
        return "book/form";
    }

    //    FORM: 수정하기 버튼 클릭후
    @PostMapping("/{id}")
    public String update (@PathVariable long id, @ModelAttribute Book book) {
        book.setId(id);
        bookService.updateBook(book);
        return "redirect:/books";
    }

    //    LIST : 정보 삭제
    @PostMapping("/{id}/delete")
    public String delete (@PathVariable long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
