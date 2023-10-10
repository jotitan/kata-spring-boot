package fr.talan.kata_springboot.service;

import fr.talan.kata_springboot.controller.dto.BookDto;
import fr.talan.kata_springboot.model.Book;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@ConditionalOnProperty(name = "book.storage", havingValue = "list",matchIfMissing = true)
public class ListBookService implements BookService {
    private List<Book> books = new ArrayList<>();
    @Override
    public Optional<Book> get(Integer id) {
        return books.stream().filter(b->b.getId().equals(id)).findFirst();
    }

    @Override
    public Book create(BookDto dto) {
        Book b = new Book(books.size()+1, dto.title());
        books.add(b);
        return b;
    }

    @Override
    public Collection<Book> findAll() {
        return books;
    }
}
