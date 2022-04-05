package com.project.chessbooksapp.book.application.port.in;

import com.project.chessbooksapp.book.domain.Book;
import com.project.chessbooksapp.commons.SaveService;
import org.springframework.stereotype.Service;

@Service
public interface BookService extends SaveService<Book> {



}
