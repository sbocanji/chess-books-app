package com.project.chessbooksapp.book.domain;

import com.project.chessbooksapp.book.domain.ReccomendBookChain;
import com.project.chessbooksapp.book.dto.BookDto;
import com.project.chessbooksapp.book.dto.UserDto;

public class WorldChampionRule implements ReccomendBookChain {
    @Override
    public void setNext(ReccomendBookChain nextInChain) {

    }

    @Override
    public int setScore(BookDto book, UserDto user, Integer score) {
        if (book.getAuthor().isWorldChampion() == user.isPreferenceOfExWorldChampion()) {
            score = score + 20;
        }
        return score;
    }
}
