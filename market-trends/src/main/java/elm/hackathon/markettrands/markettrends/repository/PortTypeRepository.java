package elm.hackathon.markettrands.markettrends.repository;

import elm.hackathon.markettrands.markettrends.domain.PortType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortTypeRepository extends JpaRepository<PortType, Long> {
}
