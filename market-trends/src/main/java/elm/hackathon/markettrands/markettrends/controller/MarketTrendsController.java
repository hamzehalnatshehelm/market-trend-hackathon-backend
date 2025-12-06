package elm.hackathon.markettrands.markettrends.controller;

import elm.hackathon.markettrands.markettrends.domain.dto.BaseResponse;
import elm.hackathon.markettrands.markettrends.domain.dto.ChartDto;
import elm.hackathon.markettrands.markettrends.domain.request.MarketTrendsRequestDashboardFilter;
import elm.hackathon.markettrands.markettrends.service.MarketTrendsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/market-trends")
public class MarketTrendsController {

    private final MarketTrendsService marketTrendsService;

    @PostMapping("/chart")
    public ResponseEntity<BaseResponse<List<ChartDto>>> chart(
            @RequestBody MarketTrendsRequestDashboardFilter filter) {
        return ResponseEntity.ok(new BaseResponse<>(marketTrendsService.chart(filter)));
    }

}
