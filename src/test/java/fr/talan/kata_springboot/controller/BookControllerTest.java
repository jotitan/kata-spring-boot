package fr.talan.kata_springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.talan.kata_springboot.controller.dto.BookDto;
import fr.talan.kata_springboot.model.Book;
import fr.talan.kata_springboot.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(properties = {"book.storage=map"})
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private BookService service;

    private MockMvc mockMvc;

    @BeforeEach
    void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void getBookMustSuccess() throws Exception {
        Book created = service.create(new BookDto("Super livre"));
        MvcResult r = this.mockMvc.perform(MockMvcRequestBuilders.get(String.format("/books/%d",created.getId()))).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Book b = new ObjectMapper().readValue(r.getResponse().getContentAsString(), Book.class);
        Assertions.assertEquals("Super livre",b.getTitle());
    }

    @Test
    void bookMissingMustFail() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/books/20")).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void createBookMustSuccess()throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/books")
                        .content("{\"title\":\"By book\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().isOk());
    }

}

