package com.project.chessbooksapp.book.application.service;

import com.project.chessbooksapp.book.application.port.in.BookDto;
import com.project.chessbooksapp.book.application.port.in.BookService;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public List<BookDto> parse(InputStream inputStream) {
        return null;
    }
}
