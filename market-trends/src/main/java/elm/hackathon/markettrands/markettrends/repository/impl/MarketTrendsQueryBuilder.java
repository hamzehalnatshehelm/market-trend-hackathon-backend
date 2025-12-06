package elm.hackathon.markettrands.markettrends.repository.impl;

import elm.hackathon.markettrands.markettrends.domain.request.MarketTrendsRequestDashboardFilter;
import elm.hackathon.markettrands.markettrends.enums.MarketTrendsScale;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class MarketTrendsQueryBuilder {

    public QuerySpec buildChartQuery(MarketTrendsRequestDashboardFilter filter) {
        String valueExpr = (filter.getScale() == MarketTrendsScale.WEIGHT)
                ? "COALESCE(SUM(net_weight), 0)"
                : "COALESCE(SUM(qty), 0)";

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT to_char(month, 'YYYY-MM') AS label, ")
                .append(valueExpr).append(" AS val ")
                .append("FROM market_trends WHERE 1=1 ");

        Map<String, Object> params = new HashMap<>();

        if (filter.getDirection() != null) {
            sql.append(" AND direction = :direction ");
            params.put("direction", filter.getDirection().name());
        }

        if (filter.getSectionId() != null && !filter.getSectionId().isBlank()) {
            sql.append(" AND fk_section_id = :sectionId ");
            params.put("sectionId", filter.getSectionId());
        }

        if (filter.getTariffs() != null && !filter.getTariffs().isEmpty()) {
            sql.append(" AND CAST(fk_tariff_id AS TEXT) IN (:tariffs) ");
            params.put("tariffs", filter.getTariffs());
        }

        if (filter.getPorts() != null && !filter.getPorts().isEmpty()) {
            sql.append(" AND CAST(fk_port_id AS TEXT) IN (:ports) ");
            params.put("ports", filter.getPorts());
        }

        if (filter.getDateFrom() != null) {
            sql.append(" AND month >= :dateFrom ");
            params.put("dateFrom", new java.sql.Date(filter.getDateFrom().getTime()));
        }
        if (filter.getDateTo() != null) {
            sql.append(" AND month <= :dateTo ");
            params.put("dateTo", new java.sql.Date(filter.getDateTo().getTime()));
        }

        sql.append(" GROUP BY label ORDER BY label ASC ");

        return new QuerySpec(sql.toString(), params);
    }

    public record QuerySpec(String sql, Map<String, Object> params) {
    }
}
