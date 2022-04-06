package com.project.chessbooksapp.store.domain;


import com.project.chessbooksapp.book.domain.Book;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String location;
    @Column
    private String name;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "store_book",
            joinColumns = {@JoinColumn(name = "store_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private List<Book> books;
}
