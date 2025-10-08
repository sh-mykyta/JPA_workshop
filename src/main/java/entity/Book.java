package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@Entity
@ToString
@RequiredArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int maxLoanDays;

    @ManyToMany
    @JoinColumn
    List<Author> authors;

    @Column
    private boolean available = true;

    public void  addAuthor(Author author) {
        authors.add(author);
    }
    public void  removeAuthor(Author author) {
        authors.remove(author);
    }

}
