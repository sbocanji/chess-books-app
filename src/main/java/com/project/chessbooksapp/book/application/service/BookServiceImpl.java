package com.project.chessbooksapp.book.application.service;

import com.project.chessbooksapp.book.application.parsers.factories.BookParserFactory;
import com.project.chessbooksapp.book.application.parsers.factories.FileType;
import com.project.chessbooksapp.book.application.parsers.factories.ParserFactory;
import com.project.chessbooksapp.book.application.port.in.BookDto;
import com.project.chessbooksapp.book.application.port.in.BookService;
import com.project.chessbooksapp.commons.Parser;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public List<BookDto> save(InputStream inputStream, FileType fileType) {
        ParserFactory<BookDto> parserFactory = new BookParserFactory();
        Parser<BookDto> bookDtoParser = parserFactory.getParser(fileType);
        return null;
    }
}
