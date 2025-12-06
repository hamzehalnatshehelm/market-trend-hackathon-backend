package elm.hackathon.markettrands.markettrends.domain.mapper;

import elm.hackathon.markettrands.markettrends.domain.PortType;
import elm.hackathon.markettrands.markettrends.domain.dto.PortTypeDto;

public class PortTypeMapper {

    private PortTypeMapper() {
    }

    public static PortTypeDto toDto(PortType portType) {

        if (portType == null) {
            return null;
        }

        return PortTypeDto
                .builder()
                .id(portType.getId())
                .nameAr(portType.getNameAr())
                .nameEn(portType.getNameEn())
                .ports(portType.getPorts().stream().map(PortMapper::toDto).toList())
                .build();
    }

}
