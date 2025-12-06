package elm.hackathon.markettrands.markettrends.service;

import elm.hackathon.markettrands.markettrends.domain.request.MarketTrendsRequestDashboardFilter;

import java.util.Map;

public interface MarketTrendsService {

    Map<String, String> chart(MarketTrendsRequestDashboardFilter filter);

}
