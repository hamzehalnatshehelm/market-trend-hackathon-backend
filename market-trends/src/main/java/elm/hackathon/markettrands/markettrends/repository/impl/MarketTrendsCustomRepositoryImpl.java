package elm.hackathon.markettrands.markettrends.repository.impl;

import elm.hackathon.markettrands.markettrends.domain.request.MarketTrendsRequestDashboardFilter;
import elm.hackathon.markettrands.markettrends.repository.MarketTrendsCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class MarketTrendsCustomRepositoryImpl implements MarketTrendsCustomRepository {

    private final EntityManager entityManager;
    private final MarketTrendsQueryBuilder queryBuilder;

    @Override
    public Map<String, String> chart(MarketTrendsRequestDashboardFilter filter) {
        var spec = queryBuilder.buildChartQuery(filter);
        Query q = entityManager.createNativeQuery(spec.sql());

        for (Map.Entry<String, Object> e : spec.params().entrySet()) {
            q.setParameter(e.getKey(), e.getValue());
        }

        @SuppressWarnings("unchecked")
        List<Object[]> rows = q.getResultList();
        Map<String, String> result = new LinkedHashMap<>();
        for (Object[] row : rows) {
            String label = (String) row[0];
            String valStr;
            Object val = row[1];
            if (val instanceof BigDecimal bd) {
                valStr = bd.stripTrailingZeros().toPlainString();
            } else if (val != null) {
                valStr = val.toString();
            } else {
                valStr = "0";
            }
            result.put(label, valStr);
        }
        return result;
    }

}
