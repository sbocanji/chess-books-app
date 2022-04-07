package com.project.chessbooksapp.book.domain;

import org.springframework.stereotype.Component;
import com.project.chessbooksapp.book.application.port.in.AuthorDto;

import java.util.ArrayList;

@Component
public class AuthorMapper {

    public Author authorDtoToAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setActive(authorDto.getActive());
        author.setWorldChampion(authorDto.getWorldChampion());
        author.setPlayerName(authorDto.getPlayerName());
        author.setNationality(authorDto.getNationality());
        author.setBooks(new ArrayList<>());
        return author;
    }

}
