package ru.kpfu.itis.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private Long id;
    private String description;
    private String isbn;
    private String name;
    private Integer pages;
    private String url;
}
