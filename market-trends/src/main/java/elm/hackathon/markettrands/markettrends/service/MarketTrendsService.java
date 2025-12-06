package elm.hackathon.markettrands.markettrends.service;

import elm.hackathon.markettrands.markettrends.domain.dto.ChartDto;
import elm.hackathon.markettrands.markettrends.domain.request.MarketTrendsRequestDashboardFilter;

import java.util.List;

public interface MarketTrendsService {

    List<ChartDto> chart(MarketTrendsRequestDashboardFilter filter);

}
