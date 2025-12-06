package elm.hackathon.markettrands.domain.dto.client.response;

import lombok.Data;

import java.util.List;

@Data
public class PaymentInquiryBodyDto {
    private PaymentInquiryDataDto data;                 // payload object
    private List<PaymentInquiryErrorItemDto> errors;

}
