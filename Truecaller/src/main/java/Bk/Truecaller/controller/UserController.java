package Bk.Truecaller.controller;

import Bk.Truecaller.peristence.POJO.LoginRequest;
import Bk.Truecaller.peristence.POJO.LoginResponse;
import Bk.Truecaller.peristence.POJO.VerifyRequest;
import Bk.Truecaller.peristence.repository.UserRepository;
import Bk.Truecaller.service.OtpService;
import Bk.Truecaller.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RequestMapping("/api/v1")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OtpService otpService;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("login the user to truecaller")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody final LoginRequest request) {
        return new ResponseEntity<>(userService.login(request), HttpStatus.OK);
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@Valid @RequestBody final VerifyRequest request) {
        return new ResponseEntity<>(userService.verifyOtp(request), HttpStatus.OK);
    }


}



