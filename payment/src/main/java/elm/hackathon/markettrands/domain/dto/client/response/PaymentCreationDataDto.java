package elm.hackathon.markettrands.domain.dto.client.response;

import lombok.Data;

@Data
public class PaymentCreationDataDto {
    private String paymentUrl;
    private String paymentRequestId;

}
