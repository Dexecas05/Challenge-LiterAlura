package com.daletguimel.bookcatalog.repository;

import com.daletguimel.bookcatalog.model.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    @Query("SELECT a FROM AuthorEntity a WHERE (a.birthYear IS NOT NULL AND a.birthYear <= :year) AND " +
            "(a.deathYear IS NULL OR a.deathYear >= :year)")
    List<AuthorEntity> findAuthorsAliveInYear(int year);
}
