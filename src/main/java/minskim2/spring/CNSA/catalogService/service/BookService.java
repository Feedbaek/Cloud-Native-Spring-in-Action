package minskim2.spring.CNSA.catalogService.service;

import lombok.RequiredArgsConstructor;
import minskim2.spring.CNSA.catalogService.dto.BookDto;
import minskim2.spring.CNSA.catalogService.entity.Book;
import minskim2.spring.CNSA.catalogService.exception.BookAlreadyExistsException;
import minskim2.spring.CNSA.catalogService.exception.BookNotFoundException;
import minskim2.spring.CNSA.catalogService.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Iterable<Book> viewBookList() {
        return bookRepository.findAll();
    }

    public Book viewBookDetails(String isbn) {
        return bookRepository.findById(isbn)
                .orElseThrow(() -> new BookNotFoundException(isbn));
    }

    @Transactional
    public Book addBookToCatalog(Book book) {
        if (bookRepository.existsById(book.getIsbn())) {
            throw new BookAlreadyExistsException(book.getIsbn());
        }
        return bookRepository.save(book);
    }
    @Transactional
    public Book addBookToCatalog(BookDto bookDto) {
        Book book = Book.builder()
                .isbn(bookDto.isbn())
                .title(bookDto.title())
                .author(bookDto.author())
                .price(bookDto.price())
                .build();
        return addBookToCatalog(book);
    }

    @Transactional
    public void removeBookFromCatalog(String isbn) {
        bookRepository.deleteById(isbn);
    }

    @Transactional
    public Book editBookDetails(Book book) {
        return bookRepository.findById(book.getIsbn())
                .map(existingBook -> {
                    existingBook.updateAuthor(book.getAuthor());
                    existingBook.updateTitle(book.getTitle());
                    existingBook.updatePrice(book.getPrice());
                    return existingBook;
                }).orElseGet(() -> bookRepository.save(book));
    }

    @Transactional
    public Book editBookDetails(BookDto bookDto) {
        Book book = Book.builder()
                .isbn(bookDto.isbn())
                .title(bookDto.title())
                .author(bookDto.author())
                .price(bookDto.price())
                .build();
        return editBookDetails(book);
    }
}
