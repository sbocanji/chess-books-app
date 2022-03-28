package com.project.chessbooksapp;

import com.project.chessbooksapp.dto.AuthorDto;
import com.project.chessbooksapp.dto.BookDto;
import com.project.chessbooksapp.services.readers.JsonReader;
import com.project.chessbooksapp.services.readers.Reader;
import com.project.chessbooksapp.services.readers.authors.AuthorCSVReader;
import com.project.chessbooksapp.services.readers.books.BookCSVReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ApplicationTesting implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        BookCSVReader bookReader = new BookCSVReader();
        List<BookDto> books = bookReader.readFile("knjige");
        for (BookDto book : books) System.out.println("ID: " + book.getId() + ", name: " + book.getBookName() + ", author: " + book.getAuthor());
        System.out.println("\n\n\n");
        AuthorCSVReader authorReader = new AuthorCSVReader();
        List<AuthorDto> authors = (List<AuthorDto>) authorReader.readFile("igraci");
        for (AuthorDto author : authors)
            System.out.println("Name: " + author.getPlayerName() + ", nationality: " + author.getNationality() + ", active: " + author.isActive() + ", worldChampionship: " + author.isWorldChampion());
        System.out.println("\n\n\n");
        Reader<BookDto> jsonReader = new JsonReader<>(BookDto.class);
        List<BookDto> newBooks = jsonReader.readFile("knjigeJson.json");
        for (BookDto book : newBooks) System.out.println("ID: " + book.getId() + ", name: " + book.getBookName() + ", author: " + book.getAuthor());
        System.out.println("\n\n\n");
        Reader<AuthorDto> jsonReaderAuthors = new JsonReader<>(AuthorDto.class);
        List<AuthorDto> newAuthors = jsonReaderAuthors.readFile("igraciJson.json");
        for (AuthorDto author : newAuthors)
            System.out.println("Name: " + author.getPlayerName() + ", nationality: " + author.getNationality() + ", active: " + author.isActive() + ", worldChampionship: " + author.isWorldChampion());
    }
}
