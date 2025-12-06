package elm.hackathon.markettrands.domain.dto.client.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultDTO {
    private String sadadNumber;

    private BigDecimal totalDueAmount;
    private BigDecimal totalDueAmountBeforeVat;
    private BigDecimal vatAmount;

    private String accountNumber;

    // e.g. "2025-12-07T04:38:30"
    private LocalDateTime expiryDate;

    private Boolean isSadadFeesApplies;
    private BigDecimal sadadFeeAmount;

    private Integer numberOfSubscriptionsRegistered;
    private Integer numberOfTransactionsRegistered;

    private List<SubscriptionDTO> subscriptions;
    private List<TransactionDTO> transactions; // empty array in sample
}

