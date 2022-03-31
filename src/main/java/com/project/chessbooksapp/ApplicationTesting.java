package com.project.chessbooksapp;

import com.project.chessbooksapp.book.application.service.*;
import com.project.chessbooksapp.book.application.port.in.AuthorDto;
import com.project.chessbooksapp.book.application.port.in.BookDto;
import com.project.chessbooksapp.commons.Parser;
import com.project.chessbooksapp.commons.LocalReader;
import com.project.chessbooksapp.commons.Reader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class ApplicationTesting implements CommandLineRunner {
    @Override
    public void run(String... args) {
        Reader localReader = new LocalReader();
        InputStream inputStreamBooks = localReader.readFile("knjige");
        InputStream inputStreamAuthors = localReader.readFile("igraci");
        InputStream inputStreamBooksJson = localReader.readFile("knjigeWithError.json");
        InputStream inputStreamAuthorsJson = localReader.readFile("igraciJson.json");
        InputStream inputStreamBooksExcel = localReader.readFile("knjigeExcel.xlsx");
        InputStream inputStreamAuthorsExcel = localReader.readFile("igraciXlsx.xlsx");

        BookCSVParser bookReader = new BookCSVParser();
        List<BookDto> books = bookReader.readEntities(inputStreamBooks);
        for (BookDto book : books) System.out.println("ID: " + book.getId() + ", name: " + book.getBookName() + ", author: " + book.getAuthor());

        System.out.println("\n\n\n");

        AuthorCSVParser authorReader = new AuthorCSVParser();
        List<AuthorDto> authors = authorReader.readEntities(inputStreamAuthors);
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

        Parser<BookDto> xlsxParser = new BookXlsxParser();
        List<BookDto> booksXlsx = xlsxParser.readEntities(inputStreamBooksExcel);
        for (BookDto book : booksXlsx) System.out.println("ID: " + book.getId() + ", name: " + book.getBookName() + ", author: " + book.getAuthor());

        System.out.println("\n\n\n");

        Parser<AuthorDto> xlsxParserAuthor = new AuthorXlsxParser();
        List<AuthorDto> authorsXlsx = xlsxParserAuthor.readEntities(inputStreamAuthorsExcel);
        for (AuthorDto author : authorsXlsx)
            System.out.println("Name: " + author.getPlayerName() + ", nationality: " + author.getNationality() + ", active: " + author.getActive() + ", worldChampionship: " + author.getWorldChampion());


    }
}
