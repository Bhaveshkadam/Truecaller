package Bk.Truecaller.peristence.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String mobileNumber;

    private String email;
}