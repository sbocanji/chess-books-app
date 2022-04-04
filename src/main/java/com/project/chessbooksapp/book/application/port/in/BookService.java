package com.project.chessbooksapp.book.application.port.in;

import com.project.chessbooksapp.commons.SaveService;
import org.springframework.stereotype.Service;

@Service
public interface BookService extends SaveService<BookDto> {



}
