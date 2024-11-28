package com.daletguimel.bookcatalog.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {
    @JsonAlias("name")
    private String name;
    @JsonAlias("birth_year")
    private Integer birthYear;
    @JsonAlias("death_year")
    private Integer deathYear;


    // Getters y Setters

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Nombre: " + name +
                ", Año de nacimiento: " + birthYear +
                ", Año de fallecimiento: " + deathYear + '\'';
    }

    // Conversion methods

    public AuthorRecord toRecord() {
        return new AuthorRecord(name, birthYear, deathYear);
    }

    public static Author fromRecord(AuthorRecord record) {
        Author author = new Author();
        author.setName(record.name());
        author.setBirthYear(record.birthYear());
        author.setDeathYear(record.deathYear());
        return author;
    }
}
