package elm.hackathon.markettrands.markettrends.service.impl;

import elm.hackathon.markettrands.markettrends.domain.dto.ChapterDto;
import elm.hackathon.markettrands.markettrends.domain.mapper.ChapterMapper;
import elm.hackathon.markettrands.markettrends.repository.ChapterRepository;
import elm.hackathon.markettrands.markettrends.service.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChapterServiceImpl implements ChapterService {

    private final ChapterRepository chapterRepository;

    @Override
    public List<ChapterDto> findAllBySectionCode(String sectionCode) {
        return chapterRepository.findAllBySectionSectionCd(sectionCode).stream().map(ChapterMapper::toDto).toList();
    }

}
