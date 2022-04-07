package com.project.chessbooksapp.book.application.port.in;

import com.project.chessbooksapp.book.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ListAvailableBooksService {
    List<Book> listAvailableBooks();
}
