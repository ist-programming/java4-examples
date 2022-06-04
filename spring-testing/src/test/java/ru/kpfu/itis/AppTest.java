package ru.kpfu.itis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.kpfu.itis.services.IBookService;


@SpringBootTest
public class AppTest {
    @Autowired
    private IBookService bookService;

    @Test
    public void contextLoads() throws Exception {
        Assertions.assertNotNull(bookService);
    }
}
