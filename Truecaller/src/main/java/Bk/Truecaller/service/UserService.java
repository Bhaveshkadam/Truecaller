package Bk.Truecaller.service;

import Bk.Truecaller.peristence.Entity.UserEntity;
import Bk.Truecaller.peristence.POJO.LoginRequest;
import Bk.Truecaller.peristence.POJO.LoginResponse;
import Bk.Truecaller.peristence.POJO.VerifyRequest;
import Bk.Truecaller.peristence.repository.UserRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private OtpService otpService;

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoginResponse login(@NonNull final LoginRequest request) {
        String otp = otpService.generateOtp();
        otpService.sendOtp(otp);

        UserEntity savedUser = userRepository.save(UserEntity.builder()
                        .firstname(request.getFirstName())
                        .lastname(request.getLastName())
                        .email(request.getEmail())
                        .mobileNumber(request.getMobileNumber())
                        .otp(otp)
                .build());

        return LoginResponse.builder()
                .userID(savedUser.getId())
                .mobileNumber(savedUser.getMobileNumber())
                .message("OTP Send Successfully, Please Verify Your Account .")
                .build();
    }

    public String verifyOtp(@NonNull final VerifyRequest request) {
        Optional<UserEntity> userOptional = userRepository.findByMobileNumber(request.getMobileNumber());
        if (userOptional.isPresent() && userOptional.get().getOtp().equals(request.getOtp())) {
            return "Login successful";
        } else {
            return "Invalid OTP";
        }
    }


}
