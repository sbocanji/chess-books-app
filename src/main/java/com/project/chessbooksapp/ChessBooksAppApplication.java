package com.project.chessbooksapp;

import com.project.chessbooksapp.dto.BookEntityDto;
import com.project.chessbooksapp.services.readers.CSVReader;
import com.project.chessbooksapp.services.readers.books.BookCSVReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ChessBooksAppApplication {

    public static void main(String[] args) {
        CSVReader<BookEntityDto> bookReader = new BookCSVReader();
        List<BookEntityDto> books = (List<BookEntityDto>) bookReader.readFile("knjige");
        for (BookEntityDto book : books)
            System.out.println("ID: " + book.getId() + ", name: " + book.getBookName() + ", author: " + book.getAuthor());

//        SpringApplication.run(ChessBooksAppApplication.class, args);
    }

}
