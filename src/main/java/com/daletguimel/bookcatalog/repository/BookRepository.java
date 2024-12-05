package com.daletguimel.bookcatalog.repository;

import com.daletguimel.bookcatalog.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    @Query("SELECT COUNT(b) FROM BookEntity b WHERE b.language = :language")
    long countByLanguage(String language);

    List<BookEntity> findByLanguage(String language);

    Optional<BookEntity> findByTitle(String title);
}
