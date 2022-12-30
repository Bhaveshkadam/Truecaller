package Bk.Truecaller.peristence.POJO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {

    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp ="/^([+]\\d{2}[ ])?\\d{10}$/", message = "enter valid number")
    private BigInteger number;

    @Pattern(regexp = "^([a-zA-Z0-9_\\.\\-]+)@([a-zA-Z0-9_\\-]+)\\.([a-zA-Z]{2,5})$", message = "email is not valid")
    private String email;

}
