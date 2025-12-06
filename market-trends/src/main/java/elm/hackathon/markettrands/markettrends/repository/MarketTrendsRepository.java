package elm.hackathon.markettrands.markettrends.repository;

import elm.hackathon.markettrands.markettrends.domain.MarketTrends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketTrendsRepository extends JpaRepository<MarketTrends, Long>, MarketTrendsCustomRepository {
}
