package elm.hackathon.markettrands.domain.dto.client.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerRequestDTO {

    private String customerId;              // e.g., random 10 digits
    private String customerEnFullName;
    private String customerArFullName;

    private String identityType;            // e.g., "700"
    private String identityTypeValue;       // e.g., "7001395784"

    private NationalAddressDTO nationalAddress;

    private String mobileNumber;            // e.g., "9665437347628"
    private String email;                   // can be empty string
    private String customerNIN;             // random 10 digits
    private String customerDescription;     // nullable

    private String customerVatNumber;       // e.g., "777877444457558"
    private Integer isRealTime;             // 1 or 0 per your payload
    private Integer expiryPeriod;           // e.g., 24 (months?)

    private List<SubscriptionDTO> subscriptions;
}
