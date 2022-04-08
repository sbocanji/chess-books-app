package com.project.chessbooksapp.book.application.service;

import com.project.chessbooksapp.book.application.parsers.factories.AuthorParserFactory;
import com.project.chessbooksapp.book.application.parsers.factories.FileType;
import com.project.chessbooksapp.book.application.port.in.AuthorService;
import com.project.chessbooksapp.book.application.port.out.AuthorRepository;
import com.project.chessbooksapp.book.application.service.AuthorServiceImpl;
import com.project.chessbooksapp.commons.LocalReader;
import com.project.chessbooksapp.commons.Reader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class AuthorSaveServiceTest {

    @Autowired
    AuthorServiceImpl authorService;
    @Autowired
    AuthorRepository authorRepository;
    Reader reader = new LocalReader();
    InputStream inputStream = reader.readFile("igraci");

    @Test
    void testAuthorSaveService() {
        // Given
        String bobbyNationality = "USA";

        // When
        authorService.save(inputStream, FileType.CSV);

        // Then
        assertThat(authorRepository.findAll()).hasSize(30);
        assertThat(authorRepository.findByPlayerName("Bobby Fischer").orElseThrow(() -> new IllegalArgumentException("Invalid author name.")).getNationality()).isEqualTo(bobbyNationality);
        assertThat(authorRepository.findByPlayerName("Magnus Carlsen").orElseThrow(() -> new IllegalArgumentException("Invalid author name.")).getActive()).isTrue();
        assertThat(authorRepository.findByPlayerName("Sergey Karjakin").orElseThrow(() -> new IllegalArgumentException("Invalid author name.")).getWorldChampion()).isFalse();
        assertThatThrownBy(() -> authorRepository.findByPlayerName("Unknown player").orElseThrow(() -> new IllegalArgumentException("Invalid author name.")))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Invalid author name.");
    }

}
