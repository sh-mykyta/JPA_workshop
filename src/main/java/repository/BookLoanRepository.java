package repository;

import entity.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookLoanRepository extends JpaRepository<BookLoan, Long> {
    BookLoan findByBorrowerId(int borrowerId);
    BookLoan findByBookId(int bookId);

    List<BookLoan> findAllByReturnedFalse();

    @Query("SELECT b FROM BookLoan b WHERE b.dueDate < CURRENT_DATE")
    List<BookLoan> findAllExpired();

    List<BookLoan> findAllByLoanDateBetween(LocalDate start, LocalDate end);

    @Modifying
    @Query("UPDATE BookLoan b SET b.returned = true WHERE b.id = :loanId")
    void markAsReturned(@Param("loanId") Long loanId);
}
