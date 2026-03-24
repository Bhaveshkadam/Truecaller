package Bk.Truecaller.controller;

import Bk.Truecaller.peristence.POJO.ApiResponse;
import Bk.Truecaller.peristence.POJO.RegisterRequest;
import Bk.Truecaller.peristence.POJO.SendOtpRequest;
import Bk.Truecaller.peristence.POJO.VerifyRequest;
import Bk.Truecaller.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    // 1. Send OTP
    @PostMapping("/send-otp")
    public ResponseEntity<ApiResponse> sendOtp(@RequestBody SendOtpRequest request) {
        return ResponseEntity.ok(
                userService.sendOtp(request.getMobileNumber())
        );
    }

    // 2. Verify OTP
    @PostMapping("/verify-otp")
    public ResponseEntity<ApiResponse> verifyOtp(@RequestBody VerifyRequest request) {
        return ResponseEntity.ok(
                userService.verifyOtp(request)
        );
    }

    // 3. Register
    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(
                userService.register(request)
        );
    }
}