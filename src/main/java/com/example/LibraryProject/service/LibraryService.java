package com.example.LibraryProject.service;

import com.example.LibraryProject.entity.Library;
import com.example.LibraryProject.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    private LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public Library findById(long id) {
        return libraryRepository.findById(id).get();
    }

    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    public Library save(Library library) {
        return libraryRepository.save(library);
    }

    public Library deleteById(long id) {
        Optional<Library> libraryById = libraryRepository.findById(id);
        if (libraryById.isPresent()) {
            libraryRepository.delete(libraryById.get());
        }
        return libraryById.get();
    }

}
