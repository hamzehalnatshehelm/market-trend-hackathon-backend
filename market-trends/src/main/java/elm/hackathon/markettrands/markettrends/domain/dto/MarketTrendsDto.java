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
public class MarketTrendsDto {

    private Long id;

    private LocalDate month;
    private String direction;
    private String typeId;
    private String hrmnzdCode;
    private String itemDescAr;
    private String itemDescEn;

    @JsonFormat(pattern = ConstantDatePattern.PATTERN_3)
    private LocalDate effDate;

    private PortTypeDto portType;
    private PortDto port;
    private SectionDto section;
    private ChapterDto chapter;
    private TariffDto tariff;

    // --- Numeric/Statistical Columns ---
    // NUMERIC without precision is typically BigDecimal in Java for full precision.
    // The CHECK constraints (imp_count >= 0) are handled at the database level,
    // not directly mappable via JPA annotations, but the type is BigDecimal.
    private BigDecimal impCount;
    private BigDecimal decCount;
    private BigDecimal itemCount;
    private BigDecimal qty;
    private BigDecimal grossWeight;
    private BigDecimal netWeight;
    private BigDecimal cifVal;
    private BigDecimal origDuty;
    private BigDecimal cifValPerQty;
    private BigDecimal origDutyPerQty;
    private BigDecimal costPerQty;


    // --- Denormalized/Description Columns ---
//    private String portTypeNameEn;
//    private String portTypeNameAr;
//    private String portCode;
//    private String codeDesc; // Renamed to follow Java convention (camelCase)
//    private String engCodeDesc; // Renamed to follow Java convention
//    private String sectionArbcDesc;
//    private String sectionEngDesc;
//    private String chapterArbcDesc;
//    private String chapterEngDesc;

}
