package com.project.chessbooksapp.book.application.service;

import com.project.chessbooksapp.book.application.port.in.BuyBookService;
import com.project.chessbooksapp.book.application.port.in.OrderBookService;
import com.project.chessbooksapp.book.application.port.out.BookInStoreRepository;
import com.project.chessbooksapp.book.domain.Book;
import com.project.chessbooksapp.book.domain.BookInStore;
import com.project.chessbooksapp.store.domain.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BuyBookServiceImpl implements BuyBookService {
    private final BookInStoreRepository bookInStoreRepository;
    private final OrderBookService orderBookService;

    @Override
    public void buyBook(Book book, Store store) {
        List<BookInStore> booksInStore = bookInStoreRepository.findAll();
        BookInStore bookInStoreNew = new BookInStore();
        for (int i = 0; i < booksInStore.size(); i++) {
            if (booksInStore.get(i).getBook().equals(book) && booksInStore.get(i).getStore().equals(store) && booksInStore.get(i).getQuantity() > 0) {
                bookInStoreNew = booksInStore.get(0);
                bookInStoreNew.setQuantity(bookInStoreNew.getQuantity() - 1);
                bookInStoreRepository.save(bookInStoreNew);
            }
        }
        orderBookService.orderBook(bookInStoreNew);
    }
}
