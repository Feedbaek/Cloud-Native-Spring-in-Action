package minskim2.spring.CNSA.catalogService.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String isbn) {
        super("The book with ISBN " + isbn + " was not found");
    }
}
