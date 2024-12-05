package com.daletguimel.bookcatalog.service;

import com.daletguimel.bookcatalog.model.Author;
import com.daletguimel.bookcatalog.model.AuthorEntity;
import com.daletguimel.bookcatalog.model.Book;
import com.daletguimel.bookcatalog.model.BookEntity;
import com.daletguimel.bookcatalog.repository.AuthorRepository;
import com.daletguimel.bookcatalog.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public void saveBook(Book book) {
        Optional<BookEntity> existingBook = bookRepository.findByTitle(book.getTitle());
        if (existingBook.isPresent()) {
            System.out.println("El libro ya existe en la base de datos.");
            return;
        }
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
        authorEntity.setBirthYear(author.getBirthYear());
        authorEntity.setDeathYear(author.getDeathYear());
        return authorEntity;
    }

    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<BookEntity> getBooksByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }

    public long countBooksByLanguage(String language){
        return bookRepository.countByLanguage(language);
    }

    public List<AuthorEntity> getAllAuthors(){
        return authorRepository.findAll();
    }

    public List<AuthorEntity> getAuthorsAliveInYear(int year){
        return authorRepository.findAuthorsAliveInYear(year);
    }

    public DoubleSummaryStatistics getDownloadStatistics(){
        return bookRepository.findAll().stream()
                .mapToDouble(BookEntity::getDownloadCount)
                .summaryStatistics();
    }

    public List<BookEntity> getTopTenByDownloads(){
        return bookRepository.findAll().stream()
                .sorted((b1, b2) -> Integer.compare(b2.getDownloadCount(), b1.getDownloadCount()))
                .limit(10)
                .collect(Collectors.toList());
    }
}
