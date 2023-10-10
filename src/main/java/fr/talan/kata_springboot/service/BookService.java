package fr.talan.kata_springboot.service;

import fr.talan.kata_springboot.controller.dto.BookDto;
import fr.talan.kata_springboot.model.Book;

import java.util.Collection;
import java.util.Optional;

public interface BookService {
    Optional<Book> get(Integer id);
    Book create(BookDto dto);
    Collection<Book> findAll();
}
