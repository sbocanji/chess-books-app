package com.project.chessbooksapp.services;

import com.project.chessbooksapp.dto.BookEntityDto;
import com.project.chessbooksapp.dto.UserEntityDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RecommendationService {

    public BookEntityDto getPreferencedBook(List<BookEntityDto> books, UserEntityDto user) {
        List<BookEntityDto> recommendedBooks = new ArrayList<>();
        boolean prefference = true;
        if (user.getPreferenceOfAuthor().equals("ex")) {
            prefference = false;
        }
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getAuthor().isActive() == prefference) {
                recommendedBooks.add(books.get(i));
            }
        }
        return recommendedBooks.get(new Random().nextInt(recommendedBooks.size()));
    }
}
