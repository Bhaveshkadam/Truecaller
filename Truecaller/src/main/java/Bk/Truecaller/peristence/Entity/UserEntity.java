package Bk.Truecaller.peristence.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "public")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @NotNull
    @Column(name = "email")
    private String email;

    @Column(name = "otp")
    private String otp;

    @NotNull
    @Column(name = "mobilenumber")
    private String mobileNumber;

}
