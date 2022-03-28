package com.project.chessbooksapp;

import com.project.chessbooksapp.dto.AuthorEntityDto;
import com.project.chessbooksapp.dto.BookEntityDto;
import com.project.chessbooksapp.dto.UserEntityDto;
import com.project.chessbooksapp.services.RecommendationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ChessBooksAppApplication {

	public static void main(String[] args) {
		List<BookEntityDto> books=new ArrayList<>();
		books.add(new BookEntityDto("1","CheckMate",new AuthorEntityDto("1",true,true,"Serbia")));
		books.add(new BookEntityDto("2","CHESS",new AuthorEntityDto("2",false,false,"Russia")));
		books.add(new BookEntityDto("3","BOOK OF ART OF CHESS",new AuthorEntityDto("3",true,true,"France")));
		books.add(new BookEntityDto("4","YES TO CHESS",new AuthorEntityDto("4",false,false,"Germany")));
		books.add(new BookEntityDto("5","BOOKS",new AuthorEntityDto("5",true,true,"France")));
		books.add(new BookEntityDto("6","KING OR QUEEN",new AuthorEntityDto("6",false,true,"Macedonia")));

		RecommendationService rs=new RecommendationService();
		BookEntityDto book=rs.getPreferencedBook(books,new UserEntityDto("milos","milos@gmail.com","ex"));
		System.out.println(book.getBookName());
		SpringApplication.run(ChessBooksAppApplication.class, args);
	}

}
