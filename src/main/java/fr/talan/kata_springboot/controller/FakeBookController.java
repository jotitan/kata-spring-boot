package fr.talan.kata_springboot.controller;

import fr.talan.kata_springboot.controller.dto.BookDto;
import fr.talan.kata_springboot.model.Book;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "/fakebooks")
public class FakeBookController {

    @GetMapping("/{id}")
    public Book getBook(@PathVariable(name = "id") Integer id, HttpServletResponse response) throws IOException {
        if (id < 5 || id > 15) {
            throw new BookNotFoundException("Impossible to find book");
        }
        return new Book(id, String.format("Title : %d", id));
    }

    @PostMapping
    public Book createBook(@RequestBody BookDto dto){
        return new Book(-1, dto.title());
    }
}
