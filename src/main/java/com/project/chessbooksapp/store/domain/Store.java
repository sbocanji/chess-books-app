package com.project.chessbooksapp.store.domain;


import com.project.chessbooksapp.book.domain.BookInStore;
import com.project.chessbooksapp.book.domain.Order;
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
//    private List<Book> books;
    @OneToMany(mappedBy = "store")
    private List<BookInStore> bookInStores;
    @OneToMany(mappedBy = "store")
    private List<Order> orders;
}
