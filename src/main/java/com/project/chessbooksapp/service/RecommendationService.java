package com.project.chessbooksapp.service;

import com.project.chessbooksapp.domain.Book;
import com.project.chessbooksapp.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RecommendationService {

    public Book getPreferencedBook(List<Book> books, User user){
        List<Book> recommendedBooks=new ArrayList<>();
        char prefference='y';
        if(user.getPreferenceOfAuthor().equals("ex")){
            prefference='n';
        }

        for(int i=0;i<books.size();i++){
            if(books.get(i).getAuthor().getActive()==prefference){
                recommendedBooks.add(books.get(i));
            }
        }
        return recommendedBooks.get(new Random().nextInt(recommendedBooks.size()));
    }
}
