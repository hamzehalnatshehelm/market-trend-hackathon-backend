package elm.hackathon.markettrands.domain.dto.client.response;

import lombok.Data;

@Data
public class PaymentCreationErrorItemDto {
    private String key;          // e.g., "2080"
    private String message;      // error description
    private String extraDetails; // can be null
}
