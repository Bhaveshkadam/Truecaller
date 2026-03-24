package Bk.Truecaller.service;

import Bk.Truecaller.peristence.Entity.UserEntity;

import Bk.Truecaller.peristence.POJO.ApiResponse;
import Bk.Truecaller.peristence.POJO.RegisterRequest;
import Bk.Truecaller.peristence.POJO.VerifyRequest;
import Bk.Truecaller.peristence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final OtpService otpService;

    // Step 1: Send OTP
    public ApiResponse sendOtp(String mobileNumber) {
        otpService.sendOtp(mobileNumber);
        return ApiResponse.builder()
                .message("OTP sent successfully")
                .build();
    }

    // Step 2: Verify OTP
    public ApiResponse verifyOtp(VerifyRequest request) {

        boolean isValid = otpService.validateOtp(
                request.getMobileNumber(),
                request.getOtp()
        );

        if (!isValid) {
            return ApiResponse.builder()
                    .message("Invalid or expired OTP")
                    .build();
        }

        Optional<UserEntity> user =
                userRepository.findByMobileNumber(request.getMobileNumber());

        if (user.isPresent()) {
            return ApiResponse.builder()
                    .message("Login successful")
                    .data(user.get())
                    .build();
        } else {
            return ApiResponse.builder()
                    .message("New user, please register")
                    .build();
        }
    }

    // Step 3: Register (only after OTP verified)
    public ApiResponse register(RegisterRequest request) {

        if (userRepository.findByMobileNumber(request.getMobileNumber()).isPresent()) {
            return ApiResponse.builder()
                    .message("User already exists")
                    .build();
        }

        UserEntity user = userRepository.save(
                UserEntity.builder()
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .email(request.getEmail())
                        .mobileNumber(request.getMobileNumber())
                        .build()
        );

        return ApiResponse.builder()
                .message("User registered successfully")
                .data(user)
                .build();
    }
}