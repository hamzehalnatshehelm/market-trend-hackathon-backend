package elm.hackathon.markettrands.domain.dto.client.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class PaymentCreationRequestDto {

    private String invoiceNumber;
    private String accountNumber;
    private LocalDateTime timeStamp;
    /**
     * TransactionType: 1 = SALE, 2 = AUTH
     */
    private int transactionType;
    private String operation;
    private String redirectUrl;
    private String paymentMethods; // Or use List<String> for better handling
    private String language;

}

