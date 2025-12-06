package elm.hackathon.markettrands.domain.dto.client.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PaymentCreationHeaderDto {

    private int status;
    private int errorsCount;
    private UUID messageId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timeStamp;

    private String culture;     // can be null
    private String productCode; // e.g., "817"

}
