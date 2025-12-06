package elm.hackathon.markettrands.domain.dto.client.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubscriptionDTO {

    // JSON keys use capitalized suffixes:
    @JsonProperty("subscriptionID")
    private Integer subscriptionId;

    @JsonProperty("serviceID")
    private String serviceId;

    private String description;

    // e.g. "2025-12-04T00:00:00"
    private LocalDateTime subscriptionStartDate;
    private LocalDateTime subscriptionEndDate;

    private Integer subscriptionVolume;

    private BigDecimal feeAmount;
    private BigDecimal feeAmountVat;
    private BigDecimal vatAmount;

    private BigDecimal vatPercentage;
    private Integer serviceType;
}

