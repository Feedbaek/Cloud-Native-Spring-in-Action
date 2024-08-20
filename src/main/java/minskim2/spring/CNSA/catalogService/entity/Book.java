package minskim2.spring.CNSA.catalogService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Entity
@Table(name = "Book")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    @Id
    private String isbn;
    private String title;
    private String author;
    private Double price;

    @Builder
    private Book(String isbn, String title, String author, Double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void updateTitle(String newTitle) {
        if (newTitle != null) {
            this.title = newTitle;
        }
    }
    public void updateAuthor(String newAuthor) {
        if (newAuthor != null) {
            this.author = newAuthor;
        }
    }
    public void updatePrice(Double newPrice) {
        if (newPrice != null) {
            this.price = newPrice;
        }
    }
}
