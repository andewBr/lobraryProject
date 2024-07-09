package com.example.LibraryProject.repository;

import com.example.LibraryProject.entity.Book;
import com.example.LibraryProject.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookService bookService;

    @Transactional
    @Test
    void testForUser() {
//        List<Book> allBooks = bookService.getAllBooks();
//        System.out.println(allBooks);
    }

}