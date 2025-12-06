package elm.hackathon.markettrands.domain.dto.client.response;

import java.util.List;

public class PaymentCreationBodyDto {
    private PaymentCreationDataDto data;                 // payload object (PaymentData in this case)
    private List<PaymentCreationErrorItemDto> errors;
}
