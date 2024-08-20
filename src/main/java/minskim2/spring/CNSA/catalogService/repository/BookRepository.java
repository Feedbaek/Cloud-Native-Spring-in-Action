package minskim2.spring.CNSA.catalogService.repository;

import minskim2.spring.CNSA.catalogService.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}
