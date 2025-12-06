package elm.hackathon.markettrands.markettrends.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import elm.hackathon.markettrands.markettrends.constant.ConstantDatePattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TariffDto {

    private BigDecimal id;
    private String label;
    private String level = "tariff";

    private String hrmnzdCode;

    @JsonFormat(pattern = ConstantDatePattern.PATTERN_3)
    private LocalDate effDate;

    private String itemDescAr;
    private String itemDescEn;

}
