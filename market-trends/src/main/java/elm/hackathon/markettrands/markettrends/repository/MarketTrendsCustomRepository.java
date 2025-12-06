package elm.hackathon.markettrands.markettrends.repository;

import elm.hackathon.markettrands.markettrends.domain.dto.ChartDto;
import elm.hackathon.markettrands.markettrends.domain.request.MarketTrendsRequestDashboardFilter;

import java.util.List;

public interface MarketTrendsCustomRepository {

    List<ChartDto> chart(MarketTrendsRequestDashboardFilter filter);

}
