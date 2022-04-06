package com.project.chessbooksapp.book.application.port.in;

import com.project.chessbooksapp.book.domain.Book;

import java.util.List;

public interface ListAllBooksService {
    List<Book> listAllBooks();
}
