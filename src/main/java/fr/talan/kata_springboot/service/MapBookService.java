package fr.talan.kata_springboot.service;

import fr.talan.kata_springboot.controller.dto.BookDto;
import fr.talan.kata_springboot.model.Book;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@ConditionalOnProperty(name = "book.storage", havingValue = "map")
public class MapBookService implements BookService {
    private Map<Integer,Book> books = new HashMap();
    @Override
    public Optional<Book> get(Integer id) {
        return books.containsKey(id) ? Optional.of(books.get(id)) : Optional.empty();
    }

    @Override
    public Book create(BookDto dto) {
        Book b = new Book(books.size()+1, dto.title());
        books.put(b.getId(), b);
        return b;
    }

    @Override
    public Collection<Book> findAll() {
        return books.values();
    }
}
