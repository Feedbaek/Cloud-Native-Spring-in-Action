package minskim2.spring.CNSA.catalogService.exception;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(String isbn) {
        super("A book with ISBN " + isbn + " already exists");
    }
}
