package elm.hackathon.markettrands.markettrends.domain.request;

import elm.hackathon.markettrands.markettrends.enums.MarketTrendsDirection;
import elm.hackathon.markettrands.markettrends.enums.MarketTrendsScale;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class MarketTrendsRequestDashboardFilter {

    private String sectionId;
    private List<String> tariffs;
    private List<String> ports;
    private Date dateFrom;
    private Date dateTo;

    private MarketTrendsScale scale;
    private MarketTrendsDirection direction;

}
