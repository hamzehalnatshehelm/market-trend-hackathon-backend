package elm.hackathon.markettrands.domain.dto.client.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NationalAddressDTO {
    private String street;
    private String buildingNumber;
    private String additionalNumber;
    private String district;
    private String city;
    private String postalCode;
    private String country;             // e.g., "SA"
}

