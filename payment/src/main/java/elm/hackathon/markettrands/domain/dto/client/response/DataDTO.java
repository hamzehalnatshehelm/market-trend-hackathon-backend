package elm.hackathon.markettrands.domain.dto.client.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataDTO {
    private ResultDTO result;
    private Boolean isStopExecuting;
    private Boolean isValid;
    private Object exception;          // Replace with a concrete error type if available
    private Integer type;
    private Object validationErrors;   // Replace with a concrete type if available
}

