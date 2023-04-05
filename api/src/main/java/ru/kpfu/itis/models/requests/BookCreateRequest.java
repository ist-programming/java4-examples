package ru.kpfu.itis.models.requests;

import javax.validation.constraints.*;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookCreateRequest {

  @Length(max = 65535)
  private String description;
  
  @NotNull
  @Pattern(regexp = "[0-9]{10,14}")
  private String isbn;
  
  @NotNull
  @Size(min = 1, max = 255)
  private String name;
  
  @NotNull
  @Range(min = 0L, max = 9999L)
  private Integer pages;
  
  @URL
  private String url;

}
