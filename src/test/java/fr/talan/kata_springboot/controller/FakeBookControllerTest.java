package fr.talan.kata_springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.talan.kata_springboot.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest()
@AutoConfigureMockMvc
class FakeBookControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void setup(){
         mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void bookWithId6MustReturnBook() throws Exception {
        MvcResult r = this.mockMvc.perform(MockMvcRequestBuilders.get("/fakebooks/6")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Book b = new ObjectMapper().readValue(r.getResponse().getContentAsString(), Book.class);
        Assertions.assertEquals("Title : 6",b.getTitle());
    }

    @Test
    void bookWithId20MustFail() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/fakebooks/20")).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void createBookMustSuccess()throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/fakebooks")
                        .content("{\"title\":\"By book\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().isOk());
    }

}

