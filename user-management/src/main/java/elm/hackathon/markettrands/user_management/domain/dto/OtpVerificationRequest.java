package elm.hackathon.markettrands.user_management.domain.dto;

import lombok.Data;

// DTO for verifying OTP
@Data
public class OtpVerificationRequest {
    private String email;
    private String otp;
}
