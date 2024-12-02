package com.daletguimel.bookcatalog.repository;

import com.daletguimel.bookcatalog.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findByLanguage(String language);
}
