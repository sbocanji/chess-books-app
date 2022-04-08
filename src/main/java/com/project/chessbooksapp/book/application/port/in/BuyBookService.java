package com.project.chessbooksapp.book.application.port.in;

import com.project.chessbooksapp.book.domain.Book;
import com.project.chessbooksapp.store.domain.Store;

public interface BuyBookService {
    void buyBook(Book book, Store store);
}
