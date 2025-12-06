package elm.hackathon.markettrands.domain.dto.client.response;

import lombok.Data;
import lombok.Getter;

@Data
public class PaymentCreationResponseDto {

    private PaymentCreationHeaderDto header;
    private PaymentCreationBodyDto body;

}
