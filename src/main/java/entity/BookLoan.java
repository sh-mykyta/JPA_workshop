package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@ToString
@RequiredArgsConstructor
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column
    private LocalDate loanDate;

    @Column
    private LocalDate dueDate;

    public BookLoan(int id, LocalDate loanDate, boolean returned, AppUser borrower, Book book) {
        if (!book.isAvailable()) {
            throw new IllegalStateException("This book is currently not available for lending.");
        }

        this.id = id;
        this.loanDate = loanDate;
        this.returned = returned;
        this.borrower = borrower;
        this.book = book;
        this.dueDate = LocalDate.now().plusDays(book.getMaxLoanDays());
        book.setAvailable(false);
    }

    public void returnBook() {
        if (returned) {
            throw new IllegalStateException("This book has already been returned.");
        }

        this.returned = true;
        if (book != null) {
            book.setAvailable(true);
        }
    }

    @Column
    private boolean returned;

    @ManyToOne
    AppUser borrower;
    @ManyToOne
    Book book;


}
