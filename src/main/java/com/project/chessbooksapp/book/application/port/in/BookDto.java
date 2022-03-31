package com.project.chessbooksapp.book.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDto {
    private String id;
    private String bookName;
    private String author;
}
