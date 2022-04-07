package com.project.chessbooksapp.book.application.service;

import com.project.chessbooksapp.book.application.port.in.ListAllBooksService;
import com.project.chessbooksapp.book.application.port.out.BookRepository;
import com.project.chessbooksapp.book.domain.Book;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class ListAllBooksImpl implements ListAllBooksService {
    private final BookRepository bookRepository;
    @Override
    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }
}
