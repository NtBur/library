package com.epam.library.controller;

import com.epam.library.dto.BookDTO;
import com.epam.library.entity.Author;
import com.epam.library.entity.Book;
import com.epam.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();

        List<BookDTO> bookDTOs = new ArrayList<>();
        for (Book book : books) {
            BookDTO dto = new BookDTO();
            dto.setId(book.getId());
            dto.setTitle(book.getTitle());
            List<String> authorNames = book.getAuthors().stream()
                    .map(Author::getName)
                    .collect(Collectors.toList());
            dto.setAuthors(authorNames);
            bookDTOs.add(dto);
        }

        return bookDTOs;
    }
}
