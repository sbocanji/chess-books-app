package com.project.chessbooksapp.book.application.port.in;

import com.project.chessbooksapp.book.domain.Book;
import org.springframework.stereotype.Service;

@Service
public interface SaveBookService extends SaveService<Book> {
}
