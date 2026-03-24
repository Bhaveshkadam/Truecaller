package Bk.Truecaller.peristence.POJO;

import lombok.Data;

@Data
public class RegisterRequest {
    private String mobileNumber;
    private String firstName;
    private String lastName;
    private String email;
}
