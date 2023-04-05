package ru.kpfu.itis.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.kpfu.itis.exceptions.BadCreateRequestException;
import ru.kpfu.itis.models.Book;
import ru.kpfu.itis.models.requests.BookCreateRequest;
import ru.kpfu.itis.models.responses.BookDetailResponse;
import ru.kpfu.itis.models.responses.BookListItemResponse;
import ru.kpfu.itis.service.BookService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Controller
@RestController
@RequestMapping("/api/v1/book")
@Tag(name = "Book Simple CRUD")
public class BookRestController {
    private final BookService bookService;

    @Autowired
    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @Operation(summary = "Get ALL Books without pagination.")
    public List<BookListItemResponse> list() {
        return StreamSupport.stream(
                        bookService.findAll().spliterator(),
                        false
                )
                .map(b -> BookListItemResponse.builder()
                        .id(b.getId())
                        .name(b.getName())
                        .build())
                .collect(Collectors.toList());
    }

    @RequestMapping("/{id}")
    public ResponseEntity<BookDetailResponse> show(@PathVariable("id") Long bookId) {
        Book book = bookService.find(bookId).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Book not found"
        ));
        return ResponseEntity.of(
                Optional.of(
                        BookDetailResponse.builder()
                                            .description(book.getDescription())
                                            .isbn(book.getIsbn())
                                            .id(book.getId())
                                            .pages(book.getPages())
                                            .url(book.getUrl())
                                            .name(book.getName())
                                            .url(book.getUrl())
                                            .build()
                )
        );
    }

    @PostMapping
    public ResponseEntity<BookDetailResponse> addHandler(
            @RequestBody @Valid BookCreateRequest bookCreateRequest,
            BindingResult result
    ) {

        if (result.hasErrors()) {
            throw new BadCreateRequestException(result);
        } else {
            Book book = bookService.save(bookCreateRequest);
            BookDetailResponse bookDetailResponse = BookDetailResponse.builder()
                    .description(book.getDescription())
                    .isbn(book.getIsbn())
                    .id(book.getId())
                    .pages(book.getPages())
                    .url(book.getUrl())
                    .name(book.getName())
                    .url(book.getUrl())
                    .build();
            return ResponseEntity.ok(bookDetailResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long bookId) {
        Book book = bookService.find(bookId).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Book not found"
        ));
        bookService.delete(book);
        return ResponseEntity.ok("Deleted");
    }
}
