package Bk.Truecaller.peristence.POJO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    @Pattern(regexp = "^([+]\\d{2})?\\d{10}$", message = "Mobile Number is not valid")
    private String mobileNumber;

    @Pattern(regexp = "^([a-zA-Z0-9_\\.\\-]+)@([a-zA-Z0-9_\\-]+)\\.([a-zA-Z]{2,5})$", message = "email is not valid")
    private String email;

}
