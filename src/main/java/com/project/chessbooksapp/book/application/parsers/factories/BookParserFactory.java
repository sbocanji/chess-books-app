package com.project.chessbooksapp.book.application.parsers.factories;

import com.project.chessbooksapp.book.application.parsers.*;
import com.project.chessbooksapp.book.application.port.in.BookDto;
import com.project.chessbooksapp.commons.Parser;

public class BookParserFactory implements ParserFactory<BookDto> {
    @Override
    public Parser<BookDto> getParser(FileType fileType) {
        switch (fileType) {
            case JSON:return new BookJsonParser(BookDto.class);
            case XLSX: return new BookXlsxParser();
            case CSV: return new BookCSVParser();
            default: throw new IllegalArgumentException("Invalid file type provided.");
        }
    }
}
