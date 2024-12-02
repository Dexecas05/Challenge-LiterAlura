package com.daletguimel.bookcatalog.repository;

import com.daletguimel.bookcatalog.model.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
}
