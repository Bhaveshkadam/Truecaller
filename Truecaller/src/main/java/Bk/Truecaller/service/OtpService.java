package Bk.Truecaller.service;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class OtpService {
    public String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    public void sendOtp( String otp) {
        // Integration with an SMS service to send OTP
        System.out.println("OTP sent to " + otp);
    }
}