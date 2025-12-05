package elm.hackathon.markettrands.markettrends.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SectionDto {

    private String sectionCd;

    private String sectionDescAr;

    private String sectionDescEn;


}
