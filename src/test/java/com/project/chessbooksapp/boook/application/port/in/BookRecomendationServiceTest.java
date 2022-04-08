package com.project.chessbooksapp.boook.application.port.in;

import com.project.chessbooksapp.book.application.BookRecommendationServiceImpl;
import com.project.chessbooksapp.book.application.port.in.BookRecommendationService;
import com.project.chessbooksapp.book.dto.AuthorDto;
import com.project.chessbooksapp.book.dto.BookDto;
import com.project.chessbooksapp.book.domain.RecommendBookChain;
import com.project.chessbooksapp.book.dto.UserDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookRecomendationServiceTest {

    BookRecommendationService bookRecommendationService;
    @Mock
    private RecommendBookChain chain;

    @BeforeEach
    public void before() {
        bookRecommendationService = new BookRecommendationServiceImpl(chain);
    }

    @Test
    void getPreferencedBookTest() {
            List<BookDto> bookDtoList = new ArrayList<>();
            BookDto bookDto = new BookDto();
            bookDto.setBookName("Test");
            bookDto.setAuthor(new AuthorDto("Pera", true, true, "Srbin"));
            bookDtoList.add(bookDto);
            UserDto user = new UserDto();
            user.setUsername("pera");
            when(chain.setScore(bookDto, user, 0)).thenReturn(50);
            bookRecommendationService = new BookRecommendationServiceImpl(chain);
            List<BookDto> result = bookRecommendationService.getPreferencedBook(bookDtoList, user);
            assertThat(result).hasSize(1);
            assertThat(result.get(0).getAuthor().getPlayerName()).isEqualTo("Pera");
    }

    @Test
    void getPreferencedBookTest2() {
        List<BookDto> bookDtoList = new ArrayList<>();
        BookDto bookDto = new BookDto();
        bookDto.setBookName("Test");
        bookDto.setAuthor(new AuthorDto("Pera", true, true, "Srbin"));
        bookDtoList.add(bookDto);
        BookDto bookDto2 = new BookDto();
        bookDto2.setBookName("King");
        bookDto2.setAuthor(new AuthorDto("Zika", true, false, "Francuz"));
        bookDtoList.add(bookDto2);
        UserDto user = new UserDto();
        user.setUsername("pera");
        when(chain.setScore(bookDto, user, 0)).thenReturn(50);
        when(chain.setScore(bookDto2, user, 0)).thenReturn(30);
        bookRecommendationService = new BookRecommendationServiceImpl(chain);
        List<BookDto> result = bookRecommendationService.getPreferencedBook(bookDtoList, user);
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getAuthor().getPlayerName()).isEqualTo("Pera");
        verify(chain).setScore(bookDto, user, 0);
        verify(chain).setScore(bookDto2, user, 0);
    }
}
