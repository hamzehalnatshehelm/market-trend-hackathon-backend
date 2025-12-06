package elm.hackathon.markettrands.markettrends.domain.mapper;

import elm.hackathon.markettrands.markettrends.domain.Port;
import elm.hackathon.markettrands.markettrends.domain.dto.PortDto;

public class PortMapper {

    private PortMapper() {
    }

    public static PortDto toDto(Port port) {

        if (port == null) {
            return null;
        }

        return PortDto
                .builder()
                .portCode(port.getPortCode())
                .codeDescAr(port.getCodeDescAr())
                .codeDescEn(port.getCodeDescEn())
                .build();
    }

}
