package minskim2.spring.CNSA.catalogService.controller;

import lombok.RequiredArgsConstructor;
import minskim2.spring.CNSA.catalogService.dto.BookDto;
import minskim2.spring.CNSA.catalogService.entity.Book;
import minskim2.spring.CNSA.catalogService.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public Iterable<Book> getAllBooks() {
        return bookService.viewBookList();
    }

    @GetMapping("{isbn}")
    public Book getByIsbn(@PathVariable("isbn") String isbn) {
        return bookService.viewBookDetails(isbn);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book post(@RequestBody BookDto bookDto) {
        return bookService.addBookToCatalog(bookDto);
    }

    @DeleteMapping("{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("isbn") String isbn) {
        bookService.removeBookFromCatalog(isbn);
    }

    @PutMapping
    public Book put(@RequestBody BookDto bookDto) {
        return bookService.editBookDetails(bookDto);
    }
}
