package com.project.chessbooksapp.book.domain;

import com.project.chessbooksapp.book.application.port.in.BookDto;
import com.project.chessbooksapp.book.application.port.out.AuthorRepository;
import com.project.chessbooksapp.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookMapper {

    private final AuthorRepository authorRepository;

    public Book bookDtoToBook(BookDto bookDto) {
        Book book = new Book();
        book.setBookName(bookDto.getBookName());
        book.setId(bookDto.getId());
        Author author = authorRepository.findByPlayerName(bookDto.getAuthor()).orElseThrow(() -> new IllegalArgumentException("Invalid author name."));
        book.setAuthor(author);
        return book;
    }

}
