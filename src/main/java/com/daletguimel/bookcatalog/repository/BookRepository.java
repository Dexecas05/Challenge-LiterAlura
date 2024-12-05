package com.daletguimel.bookcatalog.repository;

import com.daletguimel.bookcatalog.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findByLanguage(String language);

    Optional<BookEntity> findByTitle(String title);
}
