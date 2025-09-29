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
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(nullable = false, unique = true)
    private String username;


    @Column(nullable = false, unique = true)
    private String password;

    private LocalDate regDate;
    @OneToOne
    private Details userDetails;
}
