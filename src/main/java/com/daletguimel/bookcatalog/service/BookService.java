package com.daletguimel.bookcatalog.service;

import com.daletguimel.bookcatalog.model.Author;
import com.daletguimel.bookcatalog.model.AuthorEntity;
import com.daletguimel.bookcatalog.model.Book;
import com.daletguimel.bookcatalog.model.BookEntity;
import com.daletguimel.bookcatalog.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void saveBook(Book book) {
        BookEntity bookEntity = convertToBookEntity(book);
        bookRepository.save(bookEntity);
    }

    private BookEntity convertToBookEntity(Book book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(book.getTitle());
        bookEntity.setLanguage(book.getLanguages().get(0));
        bookEntity.setCopyright(book.getCopyright());
        bookEntity.setDownloadCount(book.getDownloadCount());
        List<AuthorEntity> authorEntities = book.getAuhtors().stream()
                .map(this::convertToAuthorEntity)
                .collect(Collectors.toList());
        bookEntity.setAuthors(authorEntities);
        return bookEntity;
    }

    private AuthorEntity convertToAuthorEntity(Author author) {
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName(author.getName());
        authorEntity.setBirthYear(authorEntity.getBirthYear());
        authorEntity.setDeathYear(author.getDeathYear());
        return authorEntity;
    }

    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<BookEntity> getBooksByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }
}
