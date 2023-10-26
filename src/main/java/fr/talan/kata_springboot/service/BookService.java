package fr.talan.kata_springboot.service;

import fr.talan.kata_springboot.controller.BookNotFoundException;
import fr.talan.kata_springboot.controller.dto.BookDto;
import fr.talan.kata_springboot.model.Book;

public interface BookService {
    Book create(BookDto bookDto);
    Book get(Integer id) throws BookNotFoundException;

}
