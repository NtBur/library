package com.epam.library.mapper;

import com.epam.library.model.dto.BookDTO;
import com.epam.library.model.entity.Author;
import com.epam.library.model.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "authors", target = "authorNames")
    BookDTO bookToBookDTO(Book book);

    default String fromAuthors(Author author) {
        return author.getName();
    }
}