package com.example.LibraryProject.repository;

import com.example.LibraryProject.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {
}
