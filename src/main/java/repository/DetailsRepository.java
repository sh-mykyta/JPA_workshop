package repository;

import entity.Details;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailsRepository extends JpaRepository<Details, Long> {
    Details findByEmail(String email);
    List<Details> findByNameContaining(String name);

    List<Details> findByName(String name);
}

