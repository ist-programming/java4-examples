package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.models.Book;
import ru.kpfu.itis.services.BookService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RestController
public class BookController {

  @Autowired
  private BookService bookService;


  @GetMapping("/")
  public List<Book> bookList(){
    return bookService.getBooks();
  }

  @PostMapping("/")
  public ResponseEntity<Book> createBook(@Valid Book book, BindingResult br){
    if(br.hasErrors()){
      return ResponseEntity.unprocessableEntity().body(book);
    }
    return ResponseEntity.ok(bookService.saveBook(book));
  }
}
