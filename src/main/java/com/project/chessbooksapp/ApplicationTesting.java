package com.project.chessbooksapp;

import com.project.chessbooksapp.book.application.port.in.BookDto;
import com.project.chessbooksapp.book.application.port.in.AuthorDto;
import com.project.chessbooksapp.book.application.parsers.AuthorCSVParser;
import com.project.chessbooksapp.book.application.parsers.AuthorJsonParser;
import com.project.chessbooksapp.book.application.parsers.BookCSVParser;
import com.project.chessbooksapp.book.application.parsers.BookJsonParser;
import com.project.chessbooksapp.commons.LocalReader;
import com.project.chessbooksapp.commons.Parser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class ApplicationTesting implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        InputStream inputStreamBooks = new LocalReader().readFile("knjige");
        InputStream inputStreamAuthors = new LocalReader().readFile("igraci");
        InputStream inputStreamBooksJson = new LocalReader().readFile("knjigeJson.json");
        InputStream inputStreamAuthorsJson = new LocalReader().readFile("igraciJson.json");

        BookCSVParser bookReader = new BookCSVParser();
        List<BookDto> books = bookReader.readEntities(inputStreamBooks);
        for (BookDto book : books) System.out.println("ID: " + book.getId() + ", name: " + book.getBookName() + ", author: " + book.getAuthor());

        System.out.println("\n\n\n");

        AuthorCSVParser authorReader = new AuthorCSVParser();
        List<AuthorDto> authors = (List<AuthorDto>) authorReader.readEntities(inputStreamAuthors);
        for (AuthorDto author : authors)
            System.out.println("Name: " + author.getPlayerName() + ", nationality: " + author.getNationality() + ", active: " + author.getActive() + ", worldChampionship: " + author.getWorldChampion());

        System.out.println("\n\n\n");

        Parser<BookDto> jsonReader = new BookJsonParser(BookDto.class);
        List<BookDto> newBooks = jsonReader.readEntities(inputStreamBooksJson);
        for (BookDto book : newBooks) System.out.println("ID: " + book.getId() + ", name: " + book.getBookName() + ", author: " + book.getAuthor());

        System.out.println("\n\n\n");

        Parser<AuthorDto> jsonReaderAuthors = new AuthorJsonParser(AuthorDto.class);
        List<AuthorDto> newAuthors = jsonReaderAuthors.readEntities(inputStreamAuthorsJson);

        for (AuthorDto author : newAuthors)
            System.out.println("Name: " + author.getPlayerName() + ", nationality: " + author.getNationality() + ", active: " + author.getActive() + ", worldChampionship: " + author.getWorldChampion());

        System.out.println("\n\n\n");

//        Parser<BookDto> xlsxParser = new XlsxParser<>();
//        List<BookDto> booksXlsx = xlsxParser.readEntities();

    }
}
