package com.project.chessbooksapp.book.application.port.in;

import com.project.chessbooksapp.book.application.service.BookCSVParser;
import com.project.chessbooksapp.book.application.service.BookJsonParser;
import com.project.chessbooksapp.book.application.service.BookXlsxParser;
import com.project.chessbooksapp.commons.Parser;

public class BookParserFactory implements ParserFactory<BookDto> {
    @Override
    public Parser<BookDto> getParser(String extension) {
        if(extension.equals("json")) return new BookJsonParser(BookDto.class);
        if(extension.equals("xlsx")) return new BookXlsxParser();
        return new BookCSVParser();
    }
}
