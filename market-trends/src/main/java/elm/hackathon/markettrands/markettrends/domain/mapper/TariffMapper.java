package elm.hackathon.markettrands.markettrends.domain.mapper;

import elm.hackathon.markettrands.markettrends.domain.Tariff;
import elm.hackathon.markettrands.markettrends.domain.dto.TariffDto;

public class TariffMapper {

    private TariffMapper() {
    }

    public static TariffDto toDto(Tariff tariff) {
        if (tariff == null) {
            return null;
        }

        return TariffDto
                .builder()
                .id(tariff.getSk())
                .label(tariff.getItemDescAr())
                .level("tariff")
                .hrmnzdCode(tariff.getHrmnzdCode())
                .effDate(tariff.getEffDate())
                .itemDescAr(tariff.getItemDescAr())
                .itemDescEn(tariff.getItemDescEn())
                .build();
    }

}
