package elm.hackathon.markettrands.user_management.general.exception.schema.response;

import elm.hackathon.markettrands.user_management.general.exception.enums.ErrorCode;
import lombok.Data;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

@Data
public class BaseError {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    private final boolean status;
    private final String timestamp;
    private final ErrorCode errorCode;
    private final String messageAr;
    private final String messageEn;
    private final Object detail;
    private String correlationId;

    public BaseError(ErrorCode errorCode,
                     String messageAr,
                     String messageEn,
                     Object detail) {
        this.status = false;
        this.timestamp = DATE_FORMAT.format(Instant.now());
        this.errorCode = errorCode;
        this.messageAr = messageAr;
        this.messageEn = messageEn;
        this.detail = detail;
    }

}
