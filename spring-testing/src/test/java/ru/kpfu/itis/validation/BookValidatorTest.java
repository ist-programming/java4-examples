package ru.kpfu.itis.validation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.kpfu.itis.models.Book;

import javax.validation.*;

import java.util.Set;

class BookValidatorTest {
    Validator validator;

    @BeforeEach
    void create() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void isbnGood() {
        String isbn = "1234567890123";
        Book book = new Book(isbn, "Some name", 1);
        Set<ConstraintViolation<Book>> violations = validator.validateProperty(book, "isbn");
        assertTrue(violations.isEmpty());
    }

    @Test
    void isBadIsbn() {
        String isbn = "1";
        Book book = new Book(isbn, "Some name", 1);
        Set<ConstraintViolation<Book>> violations = validator.validateProperty(book, "isbn");
        assertFalse(violations.isEmpty());
    }
}