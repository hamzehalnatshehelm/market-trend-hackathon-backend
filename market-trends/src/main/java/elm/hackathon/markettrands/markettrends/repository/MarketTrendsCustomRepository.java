package elm.hackathon.markettrands.markettrends.repository;

import elm.hackathon.markettrands.markettrends.domain.request.MarketTrendsRequestDashboardFilter;

import java.util.Map;

public interface MarketTrendsCustomRepository {

    Map<String, String> chart(MarketTrendsRequestDashboardFilter filter);

}
