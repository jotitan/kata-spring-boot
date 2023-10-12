package fr.talan.kata_springboot.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class HelloWorldControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private HelloWorldController controller;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void realCallShouldWork(){
        ResponseEntity<String> r = testRestTemplate.getForEntity(String.format("http://localhost:%d/hello",port),String.class);
        Assertions.assertEquals("Hello world",r.getBody());
    }

    @Test
    void controllerShouldExist(){
        Assertions.assertNotNull(controller);
    }

    @Test
    void mockCallShouldWork() throws Exception {
        Assertions.assertNotNull(controller);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/hello")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello world"));
    }

}
