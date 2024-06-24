package com.epam.library.controller;

import com.epam.library.mapper.AuthorMapper;
import com.epam.library.model.dto.AuthorDTO;
import com.epam.library.model.entity.Author;
import com.epam.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/authors")
    public List<AuthorDTO> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(AuthorMapper.INSTANCE::authorToAuthorDTO)
                .collect(Collectors.toList());
    }
}
