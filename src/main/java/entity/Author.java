package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String firstName;
    @Column(nullable = false, length = 100)
    private String lastName;

    @ManyToMany
    @JoinColumn
    Set<Book> writtenBooks;

    public void addBook(Book book) {
        writtenBooks.add(book);
    }
    public void removeBook(Book book) {
        writtenBooks.remove(book);
    }
}
