package elm.hackathon.markettrands.markettrends.repository;

import elm.hackathon.markettrands.markettrends.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, String> {
}
