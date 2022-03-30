package com.project.chessbooksapp.book.domain;

import com.project.chessbooksapp.book.dto.BookDto;
import com.project.chessbooksapp.book.dto.UserDto;

public interface ReccomendBookChain {
    void setNext(ReccomendBookChain nextInChain);
    int setScore(BookDto book, UserDto user, Integer score);
}
