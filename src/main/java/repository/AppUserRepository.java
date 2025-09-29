package repository;

import entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
    List<AppUser> findByRegDateBetween(LocalDate startDate, LocalDate endDate);
    AppUser findByUserDetails_Id(int id);
    AppUser findByUserDetails_EmailIgnoreCase(String email);
}
