package com.project.chessbooksapp;

import com.project.chessbooksapp.domain.Book;
import com.project.chessbooksapp.domain.Player;
import com.project.chessbooksapp.domain.User;
import com.project.chessbooksapp.service.RecommendationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ChessBooksAppApplication {

	public static void main(String[] args) {
		List<Book> books=new ArrayList<>();
		books.add(new Book("1","CheckMate",new Player("1",'y',"Serbia",'y')));
		books.add(new Book("2","CHESS",new Player("2",'y',"USA",'n')));
		books.add(new Book("3","BOOK OF ART OF CHESS",new Player("3",'n',"Serbia",'y')));
		books.add(new Book("4","YES TO CHESS",new Player("4",'y',"Russia",'y')));
		books.add(new Book("5","BOOKS",new Player("5",'n',"Macedonia",'n')));
		books.add(new Book("6","KING OR QUEEN",new Player("6",'y',"France",'y')));

		RecommendationService rs=new RecommendationService();
		Book book=rs.getPreferencedBook(books,new User("milos","milos@gmail.com","ex"));
		System.out.println(book.getBookName());
		SpringApplication.run(ChessBooksAppApplication.class, args);
	}

}
