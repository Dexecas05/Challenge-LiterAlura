package com.daletguimel.bookcatalog.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookRecord(
        @JsonAlias("title") String title,
        @JsonAlias("author")List<AuthorRecord> authors,
        @JsonAlias("languages") List<String> languages,
        @JsonAlias("copyright") Boolean copyright,
        @JsonAlias("download_count") int downloadCount
        ) {
}
