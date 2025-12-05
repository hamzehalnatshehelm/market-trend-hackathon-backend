package elm.hackathon.markettrands.user_management.controller;

import elm.hackathon.markettrands.user_management.domain.dto.JwtResponse;
import elm.hackathon.markettrands.user_management.domain.dto.OtpRequest;
import elm.hackathon.markettrands.user_management.domain.dto.OtpVerificationRequest;
import elm.hackathon.markettrands.user_management.service.EmailService;
import elm.hackathon.markettrands.user_management.service.OtpService;
import elm.hackathon.markettrands.user_management.utility.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final OtpService otpService;
    private final EmailService emailService;
    private final JwtUtil jwtUtil;

    public AuthController(OtpService otpService, EmailService emailService, JwtUtil jwtUtil) {
        this.otpService = otpService;
        this.emailService = emailService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/request-otp")
    public ResponseEntity<String> requestOtp(@RequestBody OtpRequest request) {
        String otp = otpService.generateOtp(request.getEmail());
        emailService.sendOtpEmail(request.getEmail(), otp);
        return ResponseEntity.ok("OTP sent to email");
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<JwtResponse> verifyOtp(@RequestBody OtpVerificationRequest request) {
        if (otpService.validateOtp(request.getEmail(), request.getOtp())) {
            String token = jwtUtil.generateToken(request.getEmail());
            return ResponseEntity.ok(new JwtResponse(token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
