package com.project.chessbooksapp.book.adapter.in.web;

import com.project.chessbooksapp.book.application.port.in.ListAvailableBooksService;
import com.project.chessbooksapp.book.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/books/available")
@RequiredArgsConstructor
public class ListAvailableBooksController {

    private final ListAvailableBooksService listAvailableBooksService;

    @GetMapping
    public ResponseEntity<List<Book>> listAvailableBooks() {
        return new ResponseEntity<>(listAvailableBooksService.listAvailableBooks(), HttpStatus.OK);
    }

}
