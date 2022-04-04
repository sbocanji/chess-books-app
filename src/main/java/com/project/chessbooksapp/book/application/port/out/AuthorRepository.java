package com.project.chessbooksapp.book.application.port.out;

import com.project.chessbooksapp.book.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByPlayerName(String name);
}
