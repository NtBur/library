package com.epam.library.mapper;

import com.epam.library.model.dto.AuthorDTO;
import com.epam.library.model.entity.Author;
import com.epam.library.model.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "books", target = "bookTitles")
    AuthorDTO authorToAuthorDTO(Author author);

    default String fromBooks(Book book) {
        return book.getTitle();
    }
}
