package com.project.chessbooksapp.commons;

import com.project.chessbooksapp.book.application.parsers.factories.BookParserFactory;
import com.project.chessbooksapp.book.application.parsers.factories.FileType;
import com.project.chessbooksapp.book.application.parsers.factories.ParserFactory;
import com.project.chessbooksapp.book.application.port.in.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BookParserTest {
    Parser<BookDto> bookDtoParser;
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    ParserFactory<BookDto> bookParserFactory = new BookParserFactory();

    @Test
    void testCSVBookParser() {
        // Given
        BookDto firstBook = new BookDto("0-571-09987-4", "My 60 Memorable Games", "Bobby Fischer");
        BookDto secondBook = new BookDto("978-0713478433", "Anatoly Karpov's Best Games", "Anatoly Karpov");

        // When
        bookDtoParser = bookParserFactory.getParser(FileType.CSV);
        List<BookDto> books = bookDtoParser.readEntities(classloader.getResourceAsStream("knjige"));

        // Then
        assertThat(books).hasSize(21);
        assertThat(books.get(0).getBookName()).isEqualTo(firstBook.getBookName());
        assertThat(books.get(0).getId()).isEqualTo(firstBook.getId());
        assertThat(books.get(0).getAuthor()).isEqualTo(firstBook.getAuthor());
        assertThat(books.get(1).getBookName()).isEqualTo(secondBook.getBookName());
        assertThat(books.get(1).getId()).isEqualTo(secondBook.getId());
        assertThat(books.get(1).getAuthor()).isEqualTo(secondBook.getAuthor());
        assertThatThrownBy(() -> bookDtoParser.readEntities(classloader.getResourceAsStream("knjigeWithError"))).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Invalid input.");
    }

    @Test
    void testJsonBookParser() {
        // Given
        BookDto firstBook = new BookDto("0-571-09987-4", "My 60 Memorable Games", "Bobby Fischer");
        BookDto secondBook = new BookDto("978-0713478433", "Anatoly Karpov's Best Games", "Anatoly Karpov");

        // When
        bookDtoParser = bookParserFactory.getParser(FileType.JSON);
        List<BookDto> books = bookDtoParser.readEntities(classloader.getResourceAsStream("knjigeJson.json"));

        // Then
        assertThat(books).hasSize(21);
        assertThat(books.get(0).getBookName()).isEqualTo(firstBook.getBookName());
        assertThat(books.get(0).getId()).isEqualTo(firstBook.getId());
        assertThat(books.get(0).getAuthor()).isEqualTo(firstBook.getAuthor());
        assertThat(books.get(1).getBookName()).isEqualTo(secondBook.getBookName());
        assertThat(books.get(1).getId()).isEqualTo(secondBook.getId());
        assertThat(books.get(1).getAuthor()).isEqualTo(secondBook.getAuthor());
        assertThatThrownBy(() -> bookDtoParser.readEntities(classloader.getResourceAsStream("knjigeWithError.json"))).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Invalid input.");
    }

    @Test
    void testExcelBookParser() {
        // Given
        BookDto firstBook = new BookDto("0-571-09987-4", "My 60 Memorable Games", "Bobby Fischer");
        BookDto secondBook = new BookDto("978-0713478433", "Anatoly Karpov's Best Games", "Anatoly Karpov");

        // When
        bookDtoParser = bookParserFactory.getParser(FileType.XLSX);
        List<BookDto> books = bookDtoParser.readEntities(classloader.getResourceAsStream("knjigeExcel.xlsx"));

        // Then
        assertThat(books).hasSize(21);
        assertThat(books.get(0).getBookName()).isEqualTo(firstBook.getBookName());
        assertThat(books.get(0).getId()).isEqualTo(firstBook.getId());
        assertThat(books.get(0).getAuthor()).isEqualTo(firstBook.getAuthor());
        assertThat(books.get(1).getBookName()).isEqualTo(secondBook.getBookName());
        assertThat(books.get(1).getId()).isEqualTo(secondBook.getId());
        assertThat(books.get(1).getAuthor()).isEqualTo(secondBook.getAuthor());
        assertThatThrownBy(() -> bookDtoParser.readEntities(classloader.getResourceAsStream("knjigeWithError.xlsx"))).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Invalid input.");
    }

}
