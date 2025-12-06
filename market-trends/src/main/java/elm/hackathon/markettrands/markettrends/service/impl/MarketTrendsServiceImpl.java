package elm.hackathon.markettrands.markettrends.service.impl;

import elm.hackathon.markettrands.markettrends.domain.request.MarketTrendsRequestDashboardFilter;
import elm.hackathon.markettrands.markettrends.repository.MarketTrendsRepository;
import elm.hackathon.markettrands.markettrends.service.MarketTrendsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MarketTrendsServiceImpl implements MarketTrendsService {

    private final MarketTrendsRepository marketTrendsRepository;

    @Override
    public Map<String, String> chart(MarketTrendsRequestDashboardFilter filter) {
        return marketTrendsRepository.chart(filter);
    }

}
