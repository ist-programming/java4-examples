package ru.kpfu.itis.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import ru.kpfu.itis.models.Book;
import ru.kpfu.itis.services.BookService;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
public class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService service;

    @Test
    public void getEmpty() throws Exception {
        when(service.getBooks()).thenReturn(new ArrayList<Book>(0));
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void saveBad() throws Exception {
        Book book = new Book();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("isbn", "1");
        params.add("name", "Some name");
        params.add("pages", "356");
        when(service.saveBook(book)).thenReturn(book);
        this.mockMvc.perform(post("/").params(params)).andDo(print()).andExpect(status().isUnprocessableEntity());
    }
}
