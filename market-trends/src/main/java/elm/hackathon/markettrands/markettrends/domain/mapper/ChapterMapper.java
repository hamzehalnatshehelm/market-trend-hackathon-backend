package elm.hackathon.markettrands.markettrends.domain.mapper;

import elm.hackathon.markettrands.markettrends.domain.Chapter;
import elm.hackathon.markettrands.markettrends.domain.dto.ChapterDto;

public class ChapterMapper {

    private ChapterMapper() {
    }

    public static ChapterDto toDto(Chapter chapter) {
        if (chapter == null) {
            return null;
        }

        return ChapterDto
                .builder()
                .id(chapter.getChapterCd())
                .label(chapter.getChapterDescAr())
                .chapterDescAr(chapter.getChapterDescAr())
                .chapterDescEn(chapter.getChapterDescEn())
                .level("chapter")
                .children(
                        chapter.getTariffs() != null
                                ? chapter.getTariffs().stream().map(TariffMapper::toDto).toList()
                                : null
                )
                .build();
    }

}
