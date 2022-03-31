package com.project.chessbooksapp.fileImport;

import com.project.chessbooksapp.book.application.service.BookCSVParser;
import com.project.chessbooksapp.book.application.service.BookJsonParser;
import com.project.chessbooksapp.book.application.service.BookXlsxParser;
import com.project.chessbooksapp.commons.Parser;
import com.project.chessbooksapp.book.application.port.in.BookDto;
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

    @Test
    void testCSVBookParser() {
        BookDto firstBook = new BookDto("0-571-09987-4", "My 60 Memorable Games", "Bobby Fischer");
        BookDto secondBook = new BookDto("978-0713478433", "Anatoly Karpov's Best Games", "Anatoly Karpov");

        bookDtoParser = new BookCSVParser();
        List<BookDto> books = bookDtoParser.readEntities(classloader.getResourceAsStream("knjige"));
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
        BookDto firstBook = new BookDto("0-571-09987-4", "My 60 Memorable Games", "Bobby Fischer");
        BookDto secondBook = new BookDto("978-0713478433", "Anatoly Karpov's Best Games", "Anatoly Karpov");

        bookDtoParser = new BookJsonParser(BookDto.class);
        List<BookDto> books = bookDtoParser.readEntities(classloader.getResourceAsStream("knjigeJson.json"));
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
        BookDto firstBook = new BookDto("0-571-09987-4", "My 60 Memorable Games", "Bobby Fischer");
        BookDto secondBook = new BookDto("978-0713478433", "Anatoly Karpov's Best Games", "Anatoly Karpov");

        bookDtoParser = new BookXlsxParser();
        List<BookDto> books = bookDtoParser.readEntities(classloader.getResourceAsStream("knjigeExcel.xlsx"));
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
