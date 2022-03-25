package com.project.chessbooksapp.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Book {
    private String id;
    private String bookName;
    private Player author;


}
