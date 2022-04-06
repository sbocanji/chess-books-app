package com.project.chessbooksapp.book.domain;

import com.project.chessbooksapp.store.domain.Store;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    @ManyToMany(mappedBy = "book")
    private List<Store> stores;
}
