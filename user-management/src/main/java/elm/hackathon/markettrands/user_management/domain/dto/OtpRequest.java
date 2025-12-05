package elm.hackathon.markettrands.user_management.domain.dto;

import lombok.Data;

// DTO for requesting OTP
@Data
public class OtpRequest {
    private String email;
}