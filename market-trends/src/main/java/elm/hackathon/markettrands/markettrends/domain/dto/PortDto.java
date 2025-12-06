package elm.hackathon.markettrands.markettrends.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PortDto {

    private String portCode;
    private String codeDescAr;
    private String codeDescEn;

}
