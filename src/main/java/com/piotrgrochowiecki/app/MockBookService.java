package com.piotrgrochowiecki.app;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter @Setter
public class MockBookService implements BookService {

    private List<Book> bookList;

    public MockBookService() {
        bookList = new ArrayList<>();
        bookList.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
        bookList.add(new Book(2L, "9788324627738", "Rusz głową Java.", "Sierra Kathy, Bates Bert", "Helion",
                "programming"));
        bookList.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion",
                "programming"));
    }

    @Override
    public List<Book> getAll() {
        return bookList;
    }

    @Override
    public Book getById(Long id) {
        return bookList.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("There is no book with id " + id));
    }

    @Override
    public void delete(Long id) {
        bookList.removeIf(book -> book.getId() == id);
    }

    @Override
    public void create(String isbn, String title, String author, String publisher, String type) {
        bookList.add(new Book(4L, isbn, title, author, publisher, type));
    }

    @Override
    public void update(Book book) {
        getById(book.getId());
        int indexOf = bookList.indexOf(this.getById(book.getId()));
        bookList.set(indexOf, book);
    }
}
