//package com.example.LibraryProject.controller;
//
//import com.example.LibraryProject.dto.BookDTO;
//import com.example.LibraryProject.entity.Book;
//import com.example.LibraryProject.service.BookService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/books")
//public class BookController {
//
//    private final BookService bookService;
//
//    @Autowired
//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }
//
//    @GetMapping
//    public List<BookDTO> getAllBooks() {
//        return bookService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<BookDTO> getBookById(@PathVariable long id) {
//        BookDTO bookDTO = bookService.findById(id);
//        if (bookDTO != null) {
//            return ResponseEntity.ok(bookDTO);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PostMapping
//    public BookDTO createBook(@RequestBody BookDTO bookDTO) {
//        return bookService.saveBook(bookDTO);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<BookDTO> updateBook(@PathVariable int id, @RequestBody BookDTO bookDTO) {
//        BookDTO existingBook = bookService.findById(id);
//        if (existingBook != null) {
//            bookDTO.setId(id);
//            BookDTO updatedBook = bookService.saveBook(bookDTO);
//            return ResponseEntity.ok(updatedBook);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteBook(@PathVariable long id) {
//        BookDTO bookDTO = bookService.findById(id);
//        if (bookDTO != null) {
//            bookService.deleteGenre(id);
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
