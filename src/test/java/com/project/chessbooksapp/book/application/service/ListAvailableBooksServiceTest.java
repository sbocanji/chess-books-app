package com.project.chessbooksapp.book.application.service;

import com.project.chessbooksapp.book.application.parsers.factories.FileType;
import com.project.chessbooksapp.book.application.port.in.BookDto;
import com.project.chessbooksapp.book.application.port.in.ListAvailableBooksService;
import com.project.chessbooksapp.book.application.port.out.BookRepository;
import com.project.chessbooksapp.book.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.InstanceOfAssertFactories.list;

@SpringBootTest
public class ListAvailableBooksServiceTest {
    @Autowired
    ListAvailableBooksService listAvailableBooksService;

    @Test
    void testBookSaveService() {
        // Given
        BookDto firstBook = new BookDto("0-571-09987-4", "My 60 Memorable Games", "Bobby Fischer");
        BookDto secondBook = new BookDto("978-0713478433", "Anatoly Karpov's Best Games", "Anatoly Karpov");

        // When
        List<Book> books = listAvailableBooksService.listAvailableBooks();

        // Then
//        assertThat(bookRepository.findAll()).hasSize(21);
    }
}
