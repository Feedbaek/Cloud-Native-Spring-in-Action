package minskim2.spring.CNSA.catalogService.dto;

public record BookDto(
        String isbn,
        String title,
        String author,
        Double price
) {
}
