package com.project.chessbooksapp.book.application.port.in;

import com.project.chessbooksapp.book.dto.BookDto;
import com.project.chessbooksapp.book.dto.UserDto;

import java.util.List;

public interface BookRecommendationService {
    public List<BookDto> getPreferencedBook(List<BookDto> books, UserDto user);
}
