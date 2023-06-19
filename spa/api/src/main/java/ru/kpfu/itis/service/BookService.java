package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.models.Book;
import ru.kpfu.itis.models.requests.BookCreateRequest;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class BookService {
    private Map<Long, Book> data;

    public BookService() {
        Book[] books = new Book[]{
                Book.builder()
                        .id(1L)
                        .name("Java in Action")
                        .isbn("9781617293566")
                        .pages(592)
                        .url("https://www.manning.com/books/modern-java-in-action")
                        .build(),
                Book.builder()
                        .id(2L)
                        .name("Spring in Action")
                        .isbn("9781617297571")
                        .pages(520)
                        .url("https://www.manning.com/books/spring-in-action-sixth-edition")
                        .build(),

        };
        data = new HashMap<>();
        for (Book b : books) {
            data.put(b.getId(), b);
        }
    }

    public Iterable<Book> findAll() {
        return data.values();
    }

    public Book save(BookCreateRequest request) {
        Long maxId = data.keySet().stream().max(Comparator.naturalOrder()).orElse(0L) + 1;
        Book book = Book.builder()
                        .id(maxId)
                        .url(request.getUrl())
                        .description(request.getDescription())
                        .pages(request.getPages())
                        .isbn(request.getIsbn())
                        .name(request.getName())
                        .build();
        data.put(
                maxId,
                book
        );
        return book;
    }

    public Optional<Book> find(Long bookId) {
        return Optional.ofNullable(data.get(bookId));
    }

    public void delete(Book book) {
        data.remove(book.getId());
    }
}
