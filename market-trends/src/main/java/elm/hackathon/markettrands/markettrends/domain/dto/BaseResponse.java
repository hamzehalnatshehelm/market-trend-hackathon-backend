package elm.hackathon.markettrands.markettrends.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import elm.hackathon.markettrands.markettrends.constant.ConstantDatePattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.ALWAYS)
public class BaseResponse<T> {

    public static final String ASIA_RIYADH_ZONE = "Asia/Riyadh";
    public static final ZoneId ZONE_ID = ZoneId.of(ASIA_RIYADH_ZONE);

    public BaseResponse() {
        response = null;
        status = true;
    }

    public BaseResponse(T response) {
        this.response = response;
        status = true;
    }

    private final T response;

    private final boolean status;

    @JsonFormat(timezone = ASIA_RIYADH_ZONE, pattern = ConstantDatePattern.PATTERN_2)
    private final LocalDateTime currentDate = findRiyadhZoneLocalDateTime();

    private String correlationId;

    public static LocalDateTime findRiyadhZoneLocalDateTime() {
        return LocalDateTime.now(ZONE_ID);
    }

}
