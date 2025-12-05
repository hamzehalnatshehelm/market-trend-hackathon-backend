package elm.hackathon.markettrands.user_management.repository;

import elm.hackathon.markettrands.user_management.domain.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<AppUser, Long> {
}
