package repository;

import entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findByFirstName(String firstName);
    List<Author> findByLastName(String lastName);
    List<Author> findByFirstNameOrLastNameContainsIgnoreCase(String keyword);
    Author findByWrittenBooks_Id(int bookId);

    @Modifying
    @Query("UPDATE Author a SET a.firstName = :firstName WHERE a.id = :authorId")
    void updateNameById(@Param("authorId") int authorId, @Param("firstName") String firstName);

    void deleteById(int id);
}
