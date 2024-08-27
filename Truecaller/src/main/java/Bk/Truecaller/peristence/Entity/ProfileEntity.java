package Bk.Truecaller.peristence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "profile", schema = "public")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @JsonIgnore
    @NotNull
    @Column(name = "age")
    private Integer age;

    @Column(name = "address")
    private String address;




}
