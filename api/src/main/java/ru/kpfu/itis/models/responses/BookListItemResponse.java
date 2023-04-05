package ru.kpfu.itis.models.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookListItemResponse {
    private Long id;
    private String name;
}
