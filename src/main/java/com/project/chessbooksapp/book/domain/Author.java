package com.project.chessbooksapp.book.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {

    //Author props
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String playerName;
    @Column
    private String nationality;
    @Column
    private Boolean active;
    @Column
    private Boolean worldChampion;
    @OneToMany(mappedBy = "author")
    private List<Book> books;

}
