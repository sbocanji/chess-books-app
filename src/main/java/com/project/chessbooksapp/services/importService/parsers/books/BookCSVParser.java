package com.project.chessbooksapp.services.importService.parsers.books;

import com.project.chessbooksapp.dto.BookDto;
import com.project.chessbooksapp.services.importService.parsers.CSVParser;

import java.util.HashMap;
import java.util.Map;

public class BookCSVParser extends CSVParser<BookDto, BookColumns> {
    @Override
    public BookDto readEntity(Map<BookColumns, Integer> headers, String[] values) {
        BookDto book = new BookDto();
        book.setId(values[headers.get(BookColumns.ID)]);
        book.setBookName(values[headers.get(BookColumns.NAME)]);
        book.setAuthor(values[headers.get(BookColumns.AUTHOR)]);
        return book;
    }

    @Override
    public Map<BookColumns, Integer> getHeaderColumns(String[] headers) {
        Map<BookColumns, Integer> map = new HashMap<>();
        for (int i = 0; i < headers.length; i++) map.put(BookColumns.getByName(headers[i]), i);
        return map;
    }
}
