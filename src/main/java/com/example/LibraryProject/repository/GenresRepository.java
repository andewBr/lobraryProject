package com.example.LibraryProject.repository;

import com.example.LibraryProject.entity.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenresRepository extends JpaRepository<Genres, Long> {
}
