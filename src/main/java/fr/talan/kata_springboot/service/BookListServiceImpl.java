package fr.talan.kata_springboot.service;

import fr.talan.kata_springboot.controller.BookNotFoundException;
import fr.talan.kata_springboot.controller.dto.BookDto;
import fr.talan.kata_springboot.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookListServiceImpl implements BookService{

    List<Book> bookList = new ArrayList<>();

    @Override
    public Book create(BookDto bookDto) {
        int id = bookList.size();
        Book newBook = new Book(id, bookDto.title());
        bookList.add(newBook);
        return newBook;
    }

    @Override
    public Book get(Integer id) throws BookNotFoundException {
        return bookList.stream().filter(book -> Objects.equals(book.getId(), id)).findAny().orElseThrow(() -> new BookNotFoundException("No book was found for this id"));
    }
}
