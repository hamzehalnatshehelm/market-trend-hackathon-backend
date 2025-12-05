package elm.hackathon.markettrands.markettrends.service.impl;

import elm.hackathon.markettrands.markettrends.domain.dto.SectionDto;
import elm.hackathon.markettrands.markettrends.domain.mapper.SectionMapper;
import elm.hackathon.markettrands.markettrends.repository.SectionRepository;
import elm.hackathon.markettrands.markettrends.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;

    @Override
    public List<SectionDto> findAll() {
        return sectionRepository.findAll().stream().map(SectionMapper::toDto).toList();
    }

}
