package com.example.LibraryProject.service;

import com.example.LibraryProject.dto.AuthorDTO;
import com.example.LibraryProject.dto.BookDTO;
import com.example.LibraryProject.dto.GenreDTO;
import com.example.LibraryProject.entity.Author;
import com.example.LibraryProject.entity.Book;
import com.example.LibraryProject.entity.Genres;
import com.example.LibraryProject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> findAll() {
        return bookRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BookDTO findById(long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(this::convertToDTO).orElse(null);
    }

    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = convertToEntity(bookDTO);
        Book savedBook = bookRepository.save(book);
        return convertToDTO(savedBook);
    }

    public BookDTO deleteGenre(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.delete(book.get());
            return convertToDTO(book.get());
        }
        return null;
    }

    private BookDTO convertToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setGenres(convertToGenreDTO(book.getGenres()));
        bookDTO.setAuthor(convertToAuthorDTO(book.getAuthor()));
        return bookDTO;
    }

    private GenreDTO convertToGenreDTO(Genres genres) {
        if (genres == null) return null;
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(genres.getId());
        genreDTO.setName(genres.getName());
        return genreDTO;
    }

    private AuthorDTO convertToAuthorDTO(Author author) {
        if (author == null) return null;
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setName(author.getLastName());
        return authorDTO;
    }

    private Book convertToEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setGenres(convertToEntity(bookDTO.getGenres()));
        book.setAuthor(convertToEntity(bookDTO.getAuthor()));
        return book;
    }

    private Genres convertToEntity(GenreDTO genreDTO) {
        if (genreDTO == null) return null;
        Genres genres = new Genres();
        genres.setId(genreDTO.getId());
        genres.setName(genreDTO.getName());
        return genres;
    }

    private Author convertToEntity(AuthorDTO authorDTO) {
        if (authorDTO == null) return null;
        Author author = new Author();
        author.setId(authorDTO.getId());
        author.setLastName(authorDTO.getName());
        return author;
    }
}