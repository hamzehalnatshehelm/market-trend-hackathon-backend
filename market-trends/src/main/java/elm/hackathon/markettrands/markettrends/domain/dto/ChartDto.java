package elm.hackathon.markettrands.markettrends.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChartDto {

    private String name;
    private String value;

}
