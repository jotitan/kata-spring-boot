package fr.talan.kata_springboot.controller;

import fr.talan.kata_springboot.controller.dto.BookDto;
import fr.talan.kata_springboot.model.Book;
import fr.talan.kata_springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    private final BookService service;

    BookController(@Autowired BookService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable(name = "id") Integer id) {
        return service.get(id).orElseThrow(() -> new BookNotFoundException("Impossible to find book"));
    }

    @GetMapping("")
    public Collection<Book> getBooks() {
        return service.findAll();
    }

    @PostMapping(value = "")
    public Book createBook(@RequestBody BookDto dto) {
        return service.create(dto);
    }
}
