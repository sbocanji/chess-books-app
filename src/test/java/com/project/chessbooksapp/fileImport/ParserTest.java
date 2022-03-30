package com.project.chessbooksapp.fileImport;

import com.project.chessbooksapp.book.application.service.BookCSVParser;
import com.project.chessbooksapp.commons.Parser;
import com.project.chessbooksapp.dto.BookDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.InputStream;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ParserTest {
    Parser<BookDto> bookDtoParser;
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    InputStream inputStream = classloader.getResourceAsStream("knjige");

    @Test
    void testCSVBookParser() {
        BookDto firstBook = new BookDto("0-571-09987-4", "My 60 Memorable Games", "Bobby Fischer");
        BookDto secondBook = new BookDto("978-0713478433", "Anatoly Karpov's Best Games", "Anatoly Karpov");

        bookDtoParser = new BookCSVParser();
        List<BookDto> books = bookDtoParser.readEntities(inputStream);
        assertThat(books).hasSize(21);
        assertThat(books.get(0).getBookName()).isEqualTo(firstBook.getBookName());
        assertThat(books.get(0).getId()).isEqualTo(firstBook.getId());
        assertThat(books.get(0).getAuthor()).isEqualTo(firstBook.getAuthor());
        assertThat(books.get(1).getBookName()).isEqualTo(secondBook.getBookName());
        assertThat(books.get(1).getId()).isEqualTo(secondBook.getId());
        assertThat(books.get(1).getAuthor()).isEqualTo(secondBook.getAuthor());

    }

}
