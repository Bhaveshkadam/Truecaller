package Bk.Truecaller.peristence.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyRequest {
    private String mobileNumber;
    private String otp;
}
