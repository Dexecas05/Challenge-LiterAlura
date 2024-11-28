package com.daletguimel.bookcatalog.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    @JsonAlias("title")
    private String title;
    @JsonAlias("author")
    private List<Author> auhtors;
    @JsonAlias("languages")
    private List<String> languages;
    @JsonAlias("copyright")
    private Boolean copyright;
    @JsonAlias("download_count")
    private int downloadCount;

    // Getters y Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuhtors() {
        return auhtors;
    }

    public void setAuhtors(List<Author> auhtors) {
        this.auhtors = auhtors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Boolean getCopyright() {
        return copyright;
    }

    public void setCopyright(Boolean copyright) {
        this.copyright = copyright;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return "Título: " + title + '\'' +
                ", Autor/es: " + auhtors +
                ", Lenguage/s: " + languages +
                ", Copyright: " + copyright +
                ", Descargas: " + downloadCount;
    }

    // Conversion methods
    public BookRecord toRecord(){
        List<AuthorRecord> authorRecords = auhtors.stream()
                .map(Author::toRecord)
                .toList();
    }

    public static Book fromRecord(BookRecord record) {
        Book book = new Book();
        book.setTitle(record.title());
        List<Author> authorList = record.authors().stream()
                .map(Author::fromRecord)
                .toList();
        book.setAuhtors(authorList);
        book.setLanguages(record.languages());
        book.setDownloadCount(record.downloadCount());
        return book;
    }
}
