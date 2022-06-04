package ru.kpfu.itis.services;

import ru.kpfu.itis.models.Book;

import java.util.List;

public interface IBookService {
    List<Book> getBooks();
    Book saveBook(Book book);
}
