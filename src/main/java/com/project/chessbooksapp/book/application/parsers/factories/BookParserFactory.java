package com.project.chessbooksapp.book.application.parsers.factories;

import com.project.chessbooksapp.book.application.parsers.BookCSVParser;
import com.project.chessbooksapp.book.application.parsers.BookJsonParser;
import com.project.chessbooksapp.book.application.parsers.BookXlsxParser;
import com.project.chessbooksapp.book.application.port.in.BookDto;
import com.project.chessbooksapp.commons.Parser;

public class BookParserFactory implements ParserFactory<BookDto> {
    @Override
    public Parser<BookDto> getParser(FileType fileType) {
        if(fileType == FileType.JSON) return new BookJsonParser(BookDto.class);
        if(fileType == FileType.XLSX) return new BookXlsxParser();
        return new BookCSVParser();
    }
}
