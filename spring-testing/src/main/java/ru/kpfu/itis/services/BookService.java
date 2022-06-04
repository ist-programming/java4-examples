package ru.kpfu.itis.services;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BookService implements IBookService{

    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>(2);
        books.add(new Book(1, "1234567890123", "Spring in Action", 520));
        books.add(new Book(2, "1234567890124", "Modern Java in Action: Lambdas, streams, functional and reactive programming", 592));
        return books;
    }

    public Book saveBook(Book book){
        Integer randomId = new Random().nextInt();
        book.setId(randomId);
        // Save to DB here. Or not.
        return book;
    }
}
