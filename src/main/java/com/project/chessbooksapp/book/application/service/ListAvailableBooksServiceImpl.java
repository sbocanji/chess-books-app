package com.project.chessbooksapp.book.application.service;

import com.project.chessbooksapp.book.application.port.in.ListAvailableBooksService;
import com.project.chessbooksapp.book.application.port.out.BookRepository;
import com.project.chessbooksapp.book.application.port.out.StoreRepository;
import com.project.chessbooksapp.book.domain.Book;
import com.project.chessbooksapp.store.domain.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ListAvailableBooksServiceImpl implements ListAvailableBooksService {
    private final StoreRepository storeRepository;

    @Override
    public List<Book> listAvailableBooks() {
        List<Store> stores = storeRepository.findAll();
        Map<String, Book> availableBooksMap = new HashMap<>();

        for(Store store: stores) for(Book book: store.getBooks())
            if(!availableBooksMap.containsKey(book.getId())) availableBooksMap.put(book.getId(), book);

        List<Book> availableBooks = new ArrayList<>();
        for(String bookId: availableBooksMap.keySet()) availableBooks.add(availableBooksMap.get(bookId));

        return availableBooks;
    }
}
