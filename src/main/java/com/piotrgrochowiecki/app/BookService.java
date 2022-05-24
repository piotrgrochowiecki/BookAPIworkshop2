package com.piotrgrochowiecki.app;

import java.util.List;

public interface BookService {

    List<Book> getAll();

    void delete(Long id);

    Book getById(Long id);

    void create(String isbn, String title, String author, String publisher, String type);

    void update(Book book);
}
