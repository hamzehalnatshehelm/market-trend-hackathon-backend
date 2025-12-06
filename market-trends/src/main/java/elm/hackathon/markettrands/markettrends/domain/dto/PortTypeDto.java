package elm.hackathon.markettrands.markettrends.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PortTypeDto {

    private Long id;
    private String nameEn;
    private String nameAr;
    private List<PortDto> ports;


}
