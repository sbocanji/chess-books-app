package com.project.chessbooksapp.store.domain;


import com.project.chessbooksapp.book.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
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
            name = "Store-Books",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id")}
    )
    private List<Book> books;
}
