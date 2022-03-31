package com.project.chessbooksapp.book.application.service;

import com.project.chessbooksapp.commons.JsonParser;
import com.project.chessbooksapp.book.application.port.in.BookDto;

public class BookJsonParser extends JsonParser<BookDto> {
    public BookJsonParser(Class entityClass) {
        super(entityClass);
    }

    @Override
    protected boolean validate(BookDto object) {
        return !object.getBookName().equals("") && !object.getAuthor().equals("") && !object.getId().equals("");
    }
}
