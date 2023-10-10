package fr.talan.kata_springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.talan.kata_springboot.controller.dto.BookDto;
import fr.talan.kata_springboot.model.Book;
import fr.talan.kata_springboot.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootTest(properties = {"book.storage=map"})
@AutoConfigureMockMvc
public class UnitBookControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @SpyBean
    private BookService service;

    private MockMvc mockMvc;

    @BeforeEach
    void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void getBookMustSuccess() throws Exception {
        Mockito.doReturn(Optional.of(new Book(234,"Livre n 234"))).when(service).get(234);
        MvcResult r = this.mockMvc.perform(MockMvcRequestBuilders.get(String.format("/books/%d",234))).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Book b = new ObjectMapper().readValue(r.getResponse().getContentAsString(), Book.class);
        Assertions.assertEquals("Livre n 234",b.getTitle());
    }

    @Test
    void getBooksMustSuccess() throws Exception {
        Mockito.doReturn(List.of(new Book(1,"Livre n 1"),new Book(2,"Livre n 2"),new Book(3,"Livre n 3"))).when(service).findAll();
        MvcResult r = this.mockMvc.perform(MockMvcRequestBuilders.get("/books")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        List l = new ObjectMapper().readValue(r.getResponse().getContentAsString(), List.class);
        Assertions.assertEquals(3, l.size());
    }
}

