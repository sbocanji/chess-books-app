package com.project.chessbooksapp.book.application.service;

import com.project.chessbooksapp.book.application.parsers.factories.AuthorParserFactory;
import com.project.chessbooksapp.book.application.parsers.factories.FileType;
import com.project.chessbooksapp.book.application.parsers.factories.ParserFactory;
import com.project.chessbooksapp.book.application.port.in.AuthorDto;
import com.project.chessbooksapp.book.application.port.in.AuthorService;
import com.project.chessbooksapp.book.application.port.out.AuthorRepository;
import com.project.chessbooksapp.book.domain.Author;
import com.project.chessbooksapp.book.domain.AuthorMapper;
import com.project.chessbooksapp.commons.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;
    private AuthorMapper authorMapper;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public List<Author> save(InputStream inputStream, FileType fileType) {
        ParserFactory<AuthorDto> parserFactory = new AuthorParserFactory();
        Parser<AuthorDto> authorDtoParser = parserFactory.getParser(fileType);
        List<AuthorDto> authorDtos = authorDtoParser.readEntities(inputStream);
        List<Author> authors = new ArrayList<>();
        for (AuthorDto authorDto : authorDtos) authors.add(authorMapper.authorDtoToAuthor(authorDto));
        authorRepository.saveAll(authors);
        return authors;
    }
}
