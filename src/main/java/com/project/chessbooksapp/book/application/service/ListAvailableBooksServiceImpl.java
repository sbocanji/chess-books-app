package com.project.chessbooksapp.book.application.service;

import com.project.chessbooksapp.book.application.port.in.ListAvailableBooksService;
import com.project.chessbooksapp.book.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListAvailableBooksServiceImpl implements ListAvailableBooksService {
    @Override
    public List<Book> listAvailableBooks() {
        return null;
    }
}
