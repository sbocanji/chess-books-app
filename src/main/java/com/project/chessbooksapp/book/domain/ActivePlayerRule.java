package com.project.chessbooksapp.book.domain;

import com.project.chessbooksapp.book.dto.BookDto;
import com.project.chessbooksapp.book.dto.UserDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("active")
public class ActivePlayerRule implements RecommendBookChain {
    private RecommendBookChain nextInChain;

    @Override
    public void setNext(RecommendBookChain nextInChain) {
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
