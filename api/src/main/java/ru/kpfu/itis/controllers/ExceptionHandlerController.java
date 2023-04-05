package ru.kpfu.itis.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.kpfu.itis.exceptions.BadCreateRequestException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerController{

  @ExceptionHandler(BadCreateRequestException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<List<String>> notFound(HttpServletRequest req, BadCreateRequestException exception) {
    return ResponseEntity.of(
            Optional.of(
                    exception
                            .getResult()
                            .getFieldErrors()
                            .stream()
                            .map(objectError -> objectError.getField() + " " + objectError.getDefaultMessage())
                            .collect(Collectors.toList())
            )
    );
  }
}
