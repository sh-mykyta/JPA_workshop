package repository;

import entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByIsbn(String isbn);
    List<Book> findByTitleContains(String title);

    List<Book> findByMaxLoanDaysLessThan(int maxLoanDaysIsLessThan);
}

