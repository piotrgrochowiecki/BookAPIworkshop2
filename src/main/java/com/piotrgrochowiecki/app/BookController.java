package com.piotrgrochowiecki.app;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @GetMapping("")
    public List<Book> getList() {
        return bookService.getAll();
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }

    @PostMapping("/book")
    public void createBook(@RequestParam String isbn,
                           @RequestParam String title,
                           @RequestParam String author,
                           @RequestParam String publisher,
                           @RequestParam String type) {
        bookService.create(isbn, title, author, publisher, type);
    }

    @PutMapping("")
    public void updateBook(@RequestBody Book book) {
        bookService.update(book);
    }
}
