package elm.hackathon.markettrands.markettrends.domain.mapper;

import elm.hackathon.markettrands.markettrends.domain.Section;
import elm.hackathon.markettrands.markettrends.domain.dto.SectionDto;

public class SectionMapper {

    private SectionMapper() {
    }

    public static SectionDto toDto(Section section) {
        return SectionDto
                .builder()
                .sectionCd(section.getSectionCd())
                .sectionDescAr(section.getSectionDescAr())
                .sectionDescEn(section.getSectionDescEn())
                .build();
    }

}
