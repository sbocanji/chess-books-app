package com.project.chessbooksapp.book.application.service;

import com.project.chessbooksapp.book.application.parsers.factories.BookParserFactory;
import com.project.chessbooksapp.book.application.parsers.factories.FileType;
import com.project.chessbooksapp.book.application.parsers.factories.ParserFactory;
import com.project.chessbooksapp.book.application.port.in.BookDto;
import com.project.chessbooksapp.book.application.port.in.BookService;
import com.project.chessbooksapp.book.application.port.out.AuthorRepository;
import com.project.chessbooksapp.book.application.port.out.BookRepository;
import com.project.chessbooksapp.book.domain.Author;
import com.project.chessbooksapp.book.domain.Book;
import com.project.chessbooksapp.book.domain.BookMapper;
import com.project.chessbooksapp.commons.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    @Transactional
    public List<Book> save(InputStream inputStream, FileType fileType) {
        ParserFactory<BookDto> parserFactory = new BookParserFactory();
        Parser<BookDto> bookDtoParser = parserFactory.getParser(fileType);
        List<BookDto> bookDtos = bookDtoParser.readEntities(inputStream);
        List<Book> books = new ArrayList<>();
        for(BookDto bookDto: bookDtos) books.add(bookMapper.bookDtoToBook(bookDto));
        bookRepository.saveAll(books);
        return books;
    }
}
