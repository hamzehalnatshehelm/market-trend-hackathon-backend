package elm.hackathon.markettrands.markettrends.service.impl;

import elm.hackathon.markettrands.markettrends.domain.dto.PortTypeDto;
import elm.hackathon.markettrands.markettrends.domain.mapper.PortTypeMapper;
import elm.hackathon.markettrands.markettrends.repository.PortTypeRepository;
import elm.hackathon.markettrands.markettrends.service.PortTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortTypeServiceImpl implements PortTypeService {

    private final PortTypeRepository portTypeRepository;

    @Override
    public List<PortTypeDto> findAll() {
        return portTypeRepository.findAll().stream().map(PortTypeMapper::toDto).toList();
    }
}
