package elm.hackathon.markettrands.domain.dto.client.response;

import lombok.Data;

@Data
public class PaymentInquiryErrorItemDto {
    private String key;
    private String message;
    private String extraDetails;
}
