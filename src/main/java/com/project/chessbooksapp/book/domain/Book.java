package com.project.chessbooksapp.book.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
public class Book {

    @Id
    private String id;
    @Column
    private String bookName;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
    @OneToMany(mappedBy = "book")
    private List<BookInStore> bookInStores;
    @OneToMany(mappedBy = "book")
    private List<Order> orders;
}
