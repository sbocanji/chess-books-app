package com.project.chessbooksapp.book.application.port.out;

import com.project.chessbooksapp.store.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, String> {
}
