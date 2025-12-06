package elm.hackathon.markettrands.domain.dto.client.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BodyDTO {
    private DataDTO data;
    private Object errors; // Use a concrete type if your API returns structured errors
}

