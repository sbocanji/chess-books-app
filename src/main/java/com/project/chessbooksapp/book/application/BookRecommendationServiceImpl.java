package com.project.chessbooksapp.book.application;

import com.project.chessbooksapp.book.application.port.in.BookRecommendationService;
import com.project.chessbooksapp.book.dto.UserDto;
import com.project.chessbooksapp.book.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BookRecommendationServiceImpl implements BookRecommendationService {


    @Override
    public BookDto getPreferencedBook(List<BookDto> books, UserDto user) {
        List<BookDto> recommendedBooks = new ArrayList<>();
        if(user.isPreferenceOfActive()){
            recommendedBooks.add(filterByActive(books));
        }
        else{
            if(user.isPreferenceOfExWorldChampion()){
                recommendedBooks.add(filterByEXChampion(books));
            }
        }
        return recommendedBooks.get(new Random().nextInt(recommendedBooks.size()));
    }


    public BookDto filterByEXChampion(List<BookDto> books){
        List<BookDto> recommendedBooks = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getAuthor().isWorldChampion()) {
                recommendedBooks.add(books.get(i));
            }
        }
        return recommendedBooks.get(new Random().nextInt(recommendedBooks.size()));
    }

    public BookDto filterByActive(List<BookDto> books){
        List<BookDto> recommendedBooks = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getAuthor().isActive()) {
                recommendedBooks.add(books.get(i));
            }
        }
        return recommendedBooks.get(new Random().nextInt(recommendedBooks.size()));
    }



}
