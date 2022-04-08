package com.project.chessbooksapp.book.application;

import com.project.chessbooksapp.book.application.port.in.BookRecommendationService;
import com.project.chessbooksapp.book.domain.ActivePlayerRule;
import com.project.chessbooksapp.book.domain.RecommendBookChain;
import com.project.chessbooksapp.book.domain.WorldChampionRule;
import com.project.chessbooksapp.book.dto.*;
import com.project.chessbooksapp.util.Pair;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookRecommendationServiceImpl implements BookRecommendationService {

    private final RecommendBookChain recommendBookChain;

    @Override
    public List<BookDto> getPreferencedBook(List<BookDto> books, UserDto user) {
        RecommendBookChain chain1 = new ActivePlayerRule();
        RecommendBookChain chain2 = new WorldChampionRule();
        chain1.setNext(chain2);
        List<Pair<BookDto, Integer>> bookPairs = new ArrayList<>();
        books.forEach(book -> bookPairs.add(new Pair<>(book, recommendBookChain.setScore(book, user, 0))));
        return bookPairs
                .stream()
                .sorted((b1, b2) -> b2.getValue().compareTo(b1.getValue()))
                .map(Pair::getKey)
                .collect(Collectors.toList());

    }

}
