package com.example.LibraryProject.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthorDTO implements Serializable {
    private int id;
    private String name;
}
