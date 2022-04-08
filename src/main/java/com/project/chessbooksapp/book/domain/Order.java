package com.project.chessbooksapp.book.domain;

import com.project.chessbooksapp.store.domain.Store;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    Store store;
    @ManyToOne
    Book book;
    @Column
    int price;
    // Dodati User-a nakon sto se merge-uje servis za autentifikaciju
}
