package com.project.chessbooksapp.book.application.port.out;

import com.project.chessbooksapp.book.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
