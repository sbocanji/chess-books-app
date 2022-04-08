package com.project.chessbooksapp.book.domain;

import com.project.chessbooksapp.book.dto.BookDto;
import com.project.chessbooksapp.book.dto.UserDto;
import org.springframework.stereotype.Component;

public class WorldChampionRule implements RecommendBookChain {
    @Override
    public void setNext(RecommendBookChain nextInChain) {

    }

    @Override
    public int setScore(BookDto book, UserDto user, Integer score) {
        if (book.getAuthor().isWorldChampion() == user.isPreferenceOfExWorldChampion()) {
            score = score + 20;
        }
        return score;
    }
}
