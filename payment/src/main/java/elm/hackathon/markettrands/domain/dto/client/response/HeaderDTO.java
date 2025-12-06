package elm.hackathon.markettrands.domain.dto.client.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HeaderDTO {
    private String messageId;
    private String productCode;
    private String channelId;
    private String senderId;
    private String userAgentId;
    private String functionId;
    private String extra;

    // e.g. "2025-12-06T04:38:30"
    private LocalDateTime timeStamp;

    private String language;
    private Integer status;
    private Integer errorsCount;
}

