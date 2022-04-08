package com.project.chessbooksapp.book.application.service;

import com.project.chessbooksapp.book.application.parsers.factories.FileType;
import com.project.chessbooksapp.book.application.port.in.BookDto;
import com.project.chessbooksapp.book.application.port.in.SaveBookService;
import com.project.chessbooksapp.book.application.port.out.BookRepository;
import com.project.chessbooksapp.commons.LocalReader;
import com.project.chessbooksapp.commons.Reader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class BookSaveServiceTest {

    @Autowired
    SaveBookService bookService;
    @Autowired
    BookRepository bookRepository;
    Reader reader = new LocalReader();
    InputStream inputStream = reader.readFile("knjige");

    @Test
    void testBookSaveService() {
        // Given
        BookDto firstBook = new BookDto("0-571-09987-4", "My 60 Memorable Games", "Bobby Fischer");
        BookDto secondBook = new BookDto("978-0713478433", "Anatoly Karpov's Best Games", "Anatoly Karpov");

        // When
        bookService.save(inputStream, FileType.CSV);

        // Then
        assertThat(bookRepository.findAll()).hasSize(21);
        assertThat(bookRepository.findById("0-571-09987-4").orElseThrow(() -> new IllegalArgumentException("Invalid book id.")).getBookName()).isEqualTo(firstBook.getBookName());
        assertThat(bookRepository.findById("0-571-09987-4").orElseThrow(() -> new IllegalArgumentException("Invalid book id.")).getAuthor().getPlayerName()).isEqualTo(firstBook.getAuthor());
        assertThat(bookRepository.findById("978-0713478433").orElseThrow(() -> new IllegalArgumentException("Invalid book id.")).getBookName()).isEqualTo(secondBook.getBookName());
        assertThat(bookRepository.findById("978-0713478433").orElseThrow(() -> new IllegalArgumentException("Invalid book id.")).getAuthor().getPlayerName()).isEqualTo(secondBook.getAuthor());
        assertThatThrownBy(() -> bookRepository.findById("12345").orElseThrow(() -> new IllegalArgumentException("Invalid book id.")))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Invalid book id.");
    }

}
