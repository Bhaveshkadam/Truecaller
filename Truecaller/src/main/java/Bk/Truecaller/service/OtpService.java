package Bk.Truecaller.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OtpService {

    private final Map<String, String> otpStore = new ConcurrentHashMap<>();
    private final Map<String, Long> otpExpiry = new ConcurrentHashMap<>();

    private static final long EXPIRY_TIME = 2 * 60 * 1000; // 2 min

    public String generateOtp() {
        return String.valueOf(100000 + new Random().nextInt(900000));
    }

    public void sendOtp(String mobileNumber) {
        String otp = generateOtp();

        otpStore.put(mobileNumber, otp);
        otpExpiry.put(mobileNumber, System.currentTimeMillis() + EXPIRY_TIME);

        System.out.println("OTP " + otp + " sent to " + mobileNumber);
    }

    public boolean validateOtp(String mobileNumber, String otp) {
        String storedOtp = otpStore.get(mobileNumber);
        Long expiry = otpExpiry.get(mobileNumber);

        if (storedOtp == null || expiry == null) return false;

        if (System.currentTimeMillis() > expiry) {
            otpStore.remove(mobileNumber);
            otpExpiry.remove(mobileNumber);
            return false;
        }

        boolean isValid = storedOtp.equals(otp);

        if (isValid) {
            otpStore.remove(mobileNumber);
            otpExpiry.remove(mobileNumber);
        }

        return isValid;
    }
}