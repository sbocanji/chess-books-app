package com.project.chessbooksapp.book.application.service;

import com.project.chessbooksapp.book.application.parsers.factories.AuthorParserFactory;
import com.project.chessbooksapp.book.application.parsers.factories.FileType;
import com.project.chessbooksapp.book.application.parsers.factories.ParserFactory;
import com.project.chessbooksapp.book.application.port.in.AuthorDto;
import com.project.chessbooksapp.book.application.port.in.AuthorService;
import com.project.chessbooksapp.book.application.port.out.BookRepository;
import com.project.chessbooksapp.commons.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private BookRepository bookRepository;

    @Autowired
    public AuthorServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<AuthorDto> parse(InputStream inputStream, FileType fileType) {
        ParserFactory<AuthorDto> parserFactory = new AuthorParserFactory();
        Parser<AuthorDto> authorDtoParser = parserFactory.getParser(fileType);
        List<AuthorDto> authorDtos = authorDtoParser.readEntities(inputStream);
        return null;
    }
}
