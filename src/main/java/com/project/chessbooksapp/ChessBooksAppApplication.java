package com.project.chessbooksapp;

import com.project.chessbooksapp.book.dto.AuthorDto;
import com.project.chessbooksapp.book.dto.BookDto;
import com.project.chessbooksapp.book.dto.UserDto;
import com.project.chessbooksapp.book.application.BookRecommendationServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ChessBooksAppApplication {

	public static void main(String[] args) {
		List<BookDto> books=new ArrayList<>();
		books.add(new BookDto("1","CheckMate",new AuthorDto("1",true,true,"Serbia")));
		books.add(new BookDto("2","CHESS",new AuthorDto("2",false,false,"Russia")));
		books.add(new BookDto("3","BOOK OF ART OF CHESS",new AuthorDto("3",true,true,"France")));
		books.add(new BookDto("4","YES TO CHESS",new AuthorDto("4",false,false,"Germany")));
		books.add(new BookDto("5","BOOKS",new AuthorDto("5",true,true,"France")));
		books.add(new BookDto("6","KING OR QUEEN",new AuthorDto("6",false,true,"Macedonia")));

		BookRecommendationServiceImpl rs=new BookRecommendationServiceImpl();
		BookDto book=rs.getPreferencedBook(books,new UserDto("milos","milos@gmail.com",true,false));
		System.out.println(book.getBookName());
		SpringApplication.run(ChessBooksAppApplication.class, args);
	}

}
