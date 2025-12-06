package elm.hackathon.markettrands.domain.dto.client.response;

import lombok.Data;

import java.util.List;
@Data
public class PaymentCreationBodyDto {
    private PaymentCreationDataDto data;                 // payload object (PaymentData in this case)
    private List<PaymentCreationErrorItemDto> errors;
}
