package elm.hackathon.markettrands.user_management.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String mobileNumber;
}
