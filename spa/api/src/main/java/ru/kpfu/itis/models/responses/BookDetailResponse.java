package ru.kpfu.itis.models.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDetailResponse {
    private Long id;
    private String description;
    private String isbn;
    private String name;
    private Integer pages;
    private String url;
}
