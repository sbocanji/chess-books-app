package com.project.chessbooksapp.services.readers.books;

import com.project.chessbooksapp.dto.BookEntityDto;
import com.project.chessbooksapp.services.readers.CSVReader;

import java.util.HashMap;
import java.util.Map;

public class BookCSVReader extends CSVReader<BookEntityDto, BookColumns> {
    @Override
    public BookEntityDto readEntity(Map<BookColumns, Integer> headers, String[] values) {
        BookEntityDto book = new BookEntityDto();
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
