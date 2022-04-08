package com.project.chessbooksapp.book.application.service;

import com.project.chessbooksapp.book.application.port.in.ListAvailableBooksService;
import com.project.chessbooksapp.book.application.port.out.BookRepository;
import com.project.chessbooksapp.book.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListAvailableBooksServiceImpl implements ListAvailableBooksService {
    private final BookRepository bookRepository;

    @Override
    public List<Book> listAvailableBooks() {
        List<Book> books = bookRepository.findAll();
        List<Book> availableBooks = new ArrayList<>();
        for(Book book: books) if(book.getBookInStores().size() > 0) availableBooks.add(book);

        return availableBooks;
    }
}
