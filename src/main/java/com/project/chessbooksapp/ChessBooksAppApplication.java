package com.project.chessbooksapp;

import com.project.chessbooksapp.dto.AuthorEntityDto;
import com.project.chessbooksapp.dto.BookEntityDto;
import com.project.chessbooksapp.services.readers.CSVReader;
import com.project.chessbooksapp.services.readers.authors.AuthorCSVReader;
import com.project.chessbooksapp.services.readers.books.BookCSVColumns;
import com.project.chessbooksapp.services.readers.books.BookCSVReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ChessBooksAppApplication {

    public static void main(String[] args) {
        BookCSVReader bookReader = new BookCSVReader();
        List<BookEntityDto> books = bookReader.readFile("knjige");
        for (BookEntityDto book : books)
            System.out.println("ID: " + book.getId() + ", name: " + book.getBookName() + ", author: " + book.getAuthor());
        System.out.println("\n\n\n");
        AuthorCSVReader authorReader = new AuthorCSVReader();
        List<AuthorEntityDto> authors = (List<AuthorEntityDto>) authorReader.readFile("igraci");
        for (AuthorEntityDto author : authors)
            System.out.println("Name: " + author.getPlayerName() + ", nationality: " + author.getNationality() + ", active: " + author.isActive() + ", worldChampionship: " + author.isWorldChampion());


//        SpringApplication.run(ChessBooksAppApplication.class, args);
    }

}
