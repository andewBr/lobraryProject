package com.example.LibraryProject.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookDTO implements Serializable {
    private int id;
    private String title;
    private GenreDTO genres;
    private AuthorDTO author;
}