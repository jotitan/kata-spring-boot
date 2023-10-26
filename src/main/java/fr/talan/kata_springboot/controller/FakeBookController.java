package fr.talan.kata_springboot.controller;

import fr.talan.kata_springboot.controller.dto.BookDto;
import fr.talan.kata_springboot.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/fakebooks")
public class FakeBookController {

    @GetMapping("/{id}")
    public Book getBook(@PathVariable(name = "id") Integer id) {
        if (id < 5 || id > 15) {
            throw new BookNotFoundException("Impossible to find book");
        }
        return new Book(id, String.format("Title : %d", id));
    }

    @GetMapping("/bis/{id}")
    public ResponseEntity<Book> getBookResponse(@PathVariable Integer id) {
        if (id < 5 || id > 15) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new Book(id, String.format("Title : %d", id)));
    }

}
