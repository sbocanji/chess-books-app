package com.project.chessbooksapp.book.domain;

import com.project.chessbooksapp.book.dto.BookDto;
import com.project.chessbooksapp.book.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public interface RecommendBookChain {
    void setNext(RecommendBookChain nextInChain);
    int setScore(BookDto book, UserDto user, Integer score);
}
