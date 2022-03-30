package com.project.chessbooksapp.book.domain;

import com.project.chessbooksapp.book.domain.ReccomendBookChain;
import com.project.chessbooksapp.book.dto.BookDto;
import com.project.chessbooksapp.book.dto.UserDto;

public class ActivePlayerRule implements ReccomendBookChain {
    private ReccomendBookChain nextInChain;

    @Override
    public void setNext(ReccomendBookChain nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public int setScore(BookDto book, UserDto user, Integer score) {
        if (book.getAuthor().isActive() == user.isPreferenceOfActive()) {
            score = score + 20;
        }
        return nextInChain == null ? score : nextInChain.setScore(book, user, score);
    }
}
