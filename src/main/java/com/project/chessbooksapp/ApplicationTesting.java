package com.project.chessbooksapp;

import com.project.chessbooksapp.dto.AuthorDto;
import com.project.chessbooksapp.dto.BookDto;
import com.project.chessbooksapp.services.importService.parsers.authors.AuthorCSVParser;
import com.project.chessbooksapp.services.importService.parsers.authors.AuthorXlsxParser;
import com.project.chessbooksapp.services.importService.parsers.books.BookCSVParser;
import com.project.chessbooksapp.services.importService.parsers.JsonParser;
import com.project.chessbooksapp.services.importService.parsers.Parser;
import com.project.chessbooksapp.services.importService.parsers.books.BookXlsxParser;
import com.project.chessbooksapp.services.importService.readers.LocalReader;
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
        InputStream inputStreamBooksExcel = new LocalReader().readFile("knjigeExcel.xlsx");
        InputStream inputStreamAuthorsExcel = new LocalReader().readFile("igraciXlsx.xlsx");

        BookCSVParser bookReader = new BookCSVParser();
        List<BookDto> books = bookReader.readEntities(inputStreamBooks);
        for (BookDto book : books) System.out.println("ID: " + book.getId() + ", name: " + book.getBookName() + ", author: " + book.getAuthor());

        System.out.println("\n\n\n");

        AuthorCSVParser authorReader = new AuthorCSVParser();
        List<AuthorDto> authors = (List<AuthorDto>) authorReader.readEntities(inputStreamAuthors);
        for (AuthorDto author : authors)
            System.out.println("Name: " + author.getPlayerName() + ", nationality: " + author.getNationality() + ", active: " + author.isActive() + ", worldChampionship: " + author.isWorldChampion());

        System.out.println("\n\n\n");

        Parser<BookDto> jsonReader = new JsonParser<>(BookDto.class);
        List<BookDto> newBooks = jsonReader.readEntities(inputStreamBooksJson);
        for (BookDto book : newBooks) System.out.println("ID: " + book.getId() + ", name: " + book.getBookName() + ", author: " + book.getAuthor());

        System.out.println("\n\n\n");

        Parser<AuthorDto> jsonReaderAuthors = new JsonParser<>(AuthorDto.class);
        List<AuthorDto> newAuthors = jsonReaderAuthors.readEntities(inputStreamAuthorsJson);
        for (AuthorDto author : newAuthors)
            System.out.println("Name: " + author.getPlayerName() + ", nationality: " + author.getNationality() + ", active: " + author.isActive() + ", worldChampionship: " + author.isWorldChampion());

        System.out.println("\n\n\n");

        Parser<BookDto> xlsxParser = new BookXlsxParser();
        List<BookDto> booksXlsx = xlsxParser.readEntities(inputStreamBooksExcel);
        for (BookDto book : booksXlsx) System.out.println("ID: " + book.getId() + ", name: " + book.getBookName() + ", author: " + book.getAuthor());

        System.out.println("\n\n\n");

        Parser<AuthorDto> xlsxParserAuthor = new AuthorXlsxParser();
        List<AuthorDto> authorsXlsx = xlsxParserAuthor.readEntities(inputStreamAuthorsExcel);
        for (AuthorDto author : authorsXlsx)
            System.out.println("Name: " + author.getPlayerName() + ", nationality: " + author.getNationality() + ", active: " + author.isActive() + ", worldChampionship: " + author.isWorldChampion());


    }
}
