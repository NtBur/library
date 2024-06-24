package com.epam.library;

import com.epam.library.repository.AuthorRepository;
import com.epam.library.repository.BookRepository;
import com.epam.library.model.entity.Author;
import com.epam.library.model.entity.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}


	@Bean
	public CommandLineRunner mappingDemo(AuthorRepository authorRepository,
										 BookRepository bookRepository) {
		return args -> {

			// create authors
			Author author1 = new Author("Name Author1");
			Author author2 = new Author("Name Author2");
			Author author3 = new Author("Name Author3");


			// save the authors
			authorRepository.saveAll(Arrays.asList(author1, author2, author3));

			// create three books
			Book book1 = new Book("Title book1");
			Book book2 = new Book("Title book2");
			Book book3 = new Book("Title book3");

			// save books
			bookRepository.saveAll(Arrays.asList(book1, book2, book3));

			// add books to the authors
			author1.getBooks().add(book1);
			author2.getBooks().addAll(Arrays.asList(book1, book2));
			author3.getBooks().addAll(Arrays.asList(book1, book2, book3));

			// update the authors
			authorRepository.saveAll(Arrays.asList(author1, author2, author3));

		};
	}
}
