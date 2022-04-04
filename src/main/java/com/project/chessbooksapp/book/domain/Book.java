package com.project.chessbooksapp.book.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    private String id;
    @Column
    private String bookName;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

}
