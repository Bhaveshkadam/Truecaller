package Bk.Truecaller.peristence.Entity;

import Bk.Truecaller.peristence.POJO.Gender;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "dob")
    private LocalDate dob;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "email")
    private String email;




}
