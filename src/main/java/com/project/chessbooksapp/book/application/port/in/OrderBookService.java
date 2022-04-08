package com.project.chessbooksapp.book.application.port.in;

import com.project.chessbooksapp.book.domain.BookInStore;
import com.project.chessbooksapp.book.domain.Order;


public interface OrderBookService {
    Order orderBook(BookInStore bookInStore);
}
