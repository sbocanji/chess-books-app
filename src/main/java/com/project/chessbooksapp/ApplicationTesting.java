package com.project.chessbooksapp;

import com.project.chessbooksapp.dto.AuthorEntityDto;
import com.project.chessbooksapp.dto.BookEntityDto;
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
        List<BookEntityDto> books = bookReader.readFile("knjige");
        for (BookEntityDto book : books) System.out.println("ID: " + book.getId() + ", name: " + book.getBookName() + ", author: " + book.getAuthor());
        System.out.println("\n\n\n");
        AuthorCSVReader authorReader = new AuthorCSVReader();
        List<AuthorEntityDto> authors = (List<AuthorEntityDto>) authorReader.readFile("igraci");
        for (AuthorEntityDto author : authors)
            System.out.println("Name: " + author.getPlayerName() + ", nationality: " + author.getNationality() + ", active: " + author.isActive() + ", worldChampionship: " + author.isWorldChampion());
        System.out.println("\n\n\n");
        Reader<BookEntityDto> jsonReader = new JsonReader<>(BookEntityDto.class);
        List<BookEntityDto> newBooks = jsonReader.readFile("knjigeJson.json");
        for (BookEntityDto book : newBooks) System.out.println("ID: " + book.getId() + ", name: " + book.getBookName() + ", author: " + book.getAuthor());
        System.out.println("\n\n\n");
        Reader<AuthorEntityDto> jsonReaderAuthors = new JsonReader<>(AuthorEntityDto.class);
        List<AuthorEntityDto> newAuthors = jsonReaderAuthors.readFile("igraciJson.json");
        for (AuthorEntityDto author : newAuthors)
            System.out.println("Name: " + author.getPlayerName() + ", nationality: " + author.getNationality() + ", active: " + author.isActive() + ", worldChampionship: " + author.isWorldChampion());
    }
}
