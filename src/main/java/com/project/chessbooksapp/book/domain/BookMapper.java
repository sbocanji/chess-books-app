package com.project.chessbooksapp.book.domain;

import com.project.chessbooksapp.book.application.port.in.BookDto;
import com.project.chessbooksapp.book.application.port.out.AuthorRepository;
import com.project.chessbooksapp.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    private AuthorRepository authorRepository;

    @Autowired
    public BookMapper(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Book bookDtoToBook(BookDto bookDto) {
        Book book = new Book();
        book.setBookName(bookDto.getBookName());
        book.setId(bookDto.getId());
        Author author = authorRepository.findByPlayerName(bookDto.getAuthor()).get();
        book.setAuthor(author);
        author.getBooks().add(book);
        authorRepository.save(author);
        return book;
    }

}
