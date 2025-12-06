package elm.hackathon.markettrands.domain.dto.client.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubscriptionDTO {
    private String serviceId;
    private String description;

    // Dates in payload are "yyyy-MM-dd"
    private java.time.LocalDate startDate;
    private java.time.LocalDate endDate;

    // JSON has capitalized names -> map to camelCase with @JsonProperty
    @JsonProperty("AmountWithoutVat")
    private java.math.BigDecimal amountWithoutVat;

    @JsonProperty("UnitPrice")
    private java.math.BigDecimal unitPrice;

    private Integer volume;
}

