package elm.hackathon.markettrands.domain.dto.client.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class PaymentCreationRequestDto {

    private String InvoiceNumber;
    private String AccountNumber;
    private LocalDateTime TimeStamp;
    /**
     * TransactionType: 1 = SALE, 2 = AUTH
     */
    private int TransactionType;
    private String Operation;
    private String RedirectUrl;
    private String PaymentMethods; // Or use List<String> for better handling
    private String Language;

}

