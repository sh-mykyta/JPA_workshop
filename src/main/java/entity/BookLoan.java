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

    @Column
    private boolean returned;

    @ManyToOne
    AppUser borrower;
    @ManyToOne
    Book book;

}
