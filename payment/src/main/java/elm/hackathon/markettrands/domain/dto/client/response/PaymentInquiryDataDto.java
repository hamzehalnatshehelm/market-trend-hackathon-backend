package elm.hackathon.markettrands.domain.dto.client.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentInquiryDataDto {

    private int status;                 // e.g., 17
    private String statusDescription;   // e.g., "InCompleted"
    private int statusSequence;         // e.g., 17
    private String message;             // nullable

    private String paymentTransactionNumber; // nullable
    private String invoiceNumber;            // nullable

    private BigDecimal invoiceAmount;        // nullable -> use BigDecimal for money
    private BigDecimal paidAmount;           // nullable

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;         // matches "2025-12-06T11:30:06"

    private String paymentMethod;            // nullable
    private String retrievalReferenceNumber; // nullable
    private String paymentUrl;

}
