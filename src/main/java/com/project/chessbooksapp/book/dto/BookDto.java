package com.project.chessbooksapp.book.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookDto {
    private String id;
    private String bookName;
    private AuthorDto author;
}