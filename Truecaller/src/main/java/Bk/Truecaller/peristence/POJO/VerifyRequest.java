package Bk.Truecaller.peristence.POJO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Pattern;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VerifyRequest {


    @Pattern(regexp = "^([+]\\d{2})?\\d{10}$", message = "Mobile Number is not valid")
    private String mobileNumber;

    private String otp;


}
