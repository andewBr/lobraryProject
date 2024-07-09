package com.example.LibraryProject.service;

import com.example.LibraryProject.entity.Genres;
import com.example.LibraryProject.repository.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private final GenresRepository genresRepository;

    @Autowired
    public GenreService(GenresRepository genresRepository) {
        this.genresRepository = genresRepository;
    }

    public List<Genres> getAllGenres() {
        return genresRepository.findAll();
    }

    public Genres getGenreById(long id) {
        return genresRepository.findById(id).orElse(null);
    }

    public Genres saveGenre(Genres genres) {
        return genresRepository.save(genres);
    }

    public Genres deleteGenre(long id) {
        Genres genres = genresRepository.findById(id).orElse(null);
        genresRepository.delete(genres);
        return genres;
    }
}
