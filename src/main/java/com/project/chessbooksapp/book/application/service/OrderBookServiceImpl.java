package com.project.chessbooksapp.book.application.service;

import com.project.chessbooksapp.book.application.port.in.OrderBookService;
import com.project.chessbooksapp.book.domain.BookInStore;
import com.project.chessbooksapp.book.domain.Order;

public class OrderBookServiceImpl implements OrderBookService {
    // Nakon dodavanja User-a u sistem, metoda prima i User-a koji je narucio knjigu
    @Override
    public Order orderBook(BookInStore bookInStore) {
        Order order = new Order();
        order.setBook(bookInStore.getBook());
        order.setStore(bookInStore.getStore());
        order.setPrice(bookInStore.getPrice());
        return order;
    }
}
