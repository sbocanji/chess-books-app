package com.project.chessbooksapp.services.readers.books;

import com.project.chessbooksapp.dto.BookEntityDto;
import com.project.chessbooksapp.services.readers.CSVReader;

import java.util.HashMap;
import java.util.Map;

public class BookCSVReader extends CSVReader<BookEntityDto, BookCSVColumns> {
    @Override
    public BookEntityDto readEntity(Map<BookCSVColumns, Integer> headers, String[] values) {
        BookEntityDto book = new BookEntityDto();
        book.setId(values[headers.get(BookCSVColumns.ID)]);
        book.setBookName(values[headers.get(BookCSVColumns.NAME)]);
        book.setAuthor(values[headers.get(BookCSVColumns.AUTHOR)]);
        return book;
    }

    @Override
    public Map<BookCSVColumns, Integer> getHeaderColumns(String[] headers) {
        Map<BookCSVColumns, Integer> map = new HashMap<>();
        for (int i = 0; i < headers.length; i++) map.put(BookCSVColumns.getByName(headers[i]), i);
        return map;
    }
}
