package elm.hackathon.markettrands.user_management.domain.dto;

import lombok.Data;

// DTO for JWT response
@Data
public class JwtResponse {
    private String token;
    public JwtResponse(String token) { this.token = token; }
    public String getToken() { return token; }
}
