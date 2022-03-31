package com.project.chessbooksapp.book.application.service;

import com.project.chessbooksapp.book.domain.BookColumns;
import com.project.chessbooksapp.book.application.port.in.BookDto;
import com.project.chessbooksapp.commons.XlsxParser;
import org.apache.poi.ss.usermodel.Row;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookXlsxParser extends XlsxParser<BookDto, BookColumns> {

    @Override
    public BookDto readEntity(Map<BookColumns, Integer> headers, Row row) {
        BookDto book = new BookDto();
        book.setId(String.valueOf(row.getCell(headers.get(BookColumns.ID))));
        book.setBookName(String.valueOf(row.getCell(headers.get(BookColumns.NAME))));
        book.setAuthor(String.valueOf(row.getCell(headers.get(BookColumns.AUTHOR))));
        return book;
    }

    @Override
    public Map<BookColumns, Integer> getHeaderColumns(List<String> headers) {
        Map<BookColumns, Integer> map = new HashMap<>();
        for (int i = 0; i < headers.size(); i++) map.put(BookColumns.getByName(headers.get(i)), i);
        return map;
    }
}
