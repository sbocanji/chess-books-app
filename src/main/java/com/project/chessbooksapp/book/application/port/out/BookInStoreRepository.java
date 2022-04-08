package com.project.chessbooksapp.book.application.port.out;

import com.project.chessbooksapp.book.domain.BookInStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookInStoreRepository extends JpaRepository<BookInStore, String> {
}
