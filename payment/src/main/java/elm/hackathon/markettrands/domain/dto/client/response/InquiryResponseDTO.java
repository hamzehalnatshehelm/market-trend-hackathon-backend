package elm.hackathon.markettrands.domain.dto.client.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InquiryResponseDTO {
    private HeaderDTO header;
    private BodyDTO body;

}
