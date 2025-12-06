package elm.hackathon.markettrands.markettrends.service;

import elm.hackathon.markettrands.markettrends.domain.dto.ChapterDto;

import java.util.List;

public interface ChapterService {

    List<ChapterDto> findAllBySectionCode(String sectionCode);

}
