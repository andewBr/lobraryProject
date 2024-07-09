package com.example.LibraryProject.controller;

import com.example.LibraryProject.dto.BookDTO;
import com.example.LibraryProject.entity.Book;
import com.example.LibraryProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookViewController {

    private final BookService bookService;

    @Autowired
    public BookViewController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    String findAll(Model model) {
        List<BookDTO> findAll = bookService.findAll();
        model.addAttribute("books", findAll);
        return "books";
    }
}
