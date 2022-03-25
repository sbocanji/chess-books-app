package com.project.chessbooksapp.services.readers.books;

import com.project.chessbooksapp.dto.BookEntityDto;
import com.project.chessbooksapp.services.readers.CSVReader;

public class BookCSVReader extends CSVReader<BookEntityDto> {
    @Override
    public BookEntityDto readEntity(String[] headers, String[] values) {
        BookEntityDto bookEntityDto = new BookEntityDto();
        for (int i = 0; i < headers.length; i++) {
            if(headers[i].equals("id")) bookEntityDto.setId(values[i]);
            if(headers[i].equals("bookName")) bookEntityDto.setBookName(values[i]);
            if(headers[i].equals("author")) bookEntityDto.setAuthor(values[i]);
        }
        return bookEntityDto;
    }
}
